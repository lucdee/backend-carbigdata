package com.carbigdata.backend.domain.foto;

import com.carbigdata.backend.domain.ocorrencia.Ocorrencia;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "foto_ocorrencia")
public class FotoOcorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_foto_ocorrencia")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_ocorrencia")
    private Ocorrencia ocorrencia;

    @Column(name = "dta_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @Column(name = "dsc_path_bucket", nullable = false)
    private String pathBucket;

    @Column(name = "dsc_hash", nullable = false)
    private String hash;

    @PrePersist
    void prePersist() { this.dataCriacao = LocalDateTime.now(); }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Ocorrencia getOcorrencia() { return ocorrencia; }
    public void setOcorrencia(Ocorrencia ocorrencia) { this.ocorrencia = ocorrencia; }
    public LocalDateTime getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }
    public String getPathBucket() { return pathBucket; }
    public void setPathBucket(String pathBucket) { this.pathBucket = pathBucket; }
    public String getHash() { return hash; }
    public void setHash(String hash) { this.hash = hash; }
}
