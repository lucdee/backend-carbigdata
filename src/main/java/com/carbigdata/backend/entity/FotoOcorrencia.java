package com.carbigdata.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
    void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }
}
