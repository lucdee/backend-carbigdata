package com.carbigdata.backend.storage;

import java.io.InputStream;

public interface ObjectStoragePort {
    StoredObject upload(String objectName, String contentType, InputStream stream, long size);

    record StoredObject(String path, String hash) {}
}
