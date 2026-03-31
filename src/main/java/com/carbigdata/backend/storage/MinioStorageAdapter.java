package com.carbigdata.backend.storage;

import io.minio.*;
import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MinioStorageAdapter implements ObjectStoragePort {

    private final MinioClient minioClient;
    private final String bucket;

    public MinioStorageAdapter(
            @Value("${app.minio.url}") String url,
            @Value("${app.minio.access-key}") String accessKey,
            @Value("${app.minio.secret-key}") String secretKey,
            @Value("${app.minio.bucket}") String bucket
    ) {
        this.bucket = bucket;
        this.minioClient = MinioClient.builder().endpoint(url).credentials(accessKey, secretKey).build();
    }

    @PostConstruct
    void ensureBucket() throws Exception {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }

    @Override
    public StoredObject upload(String objectName, String contentType, InputStream stream, long size) {
        try {
            ObjectWriteResponse response = minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucket)
                            .object(objectName)
                            .stream(stream, size, -1)
                            .contentType(contentType)
                            .build()
            );
            return new StoredObject(bucket + "/" + objectName, response.etag());
        } catch (Exception e) {
            throw new IllegalStateException("Falha ao enviar arquivo para MinIO", e);
        }
    }
}
