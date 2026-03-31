package com.carbigdata.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ocorrencia")
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_ocorrencia")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_endereco")
    private Endereco endereco;

    @Column(name = "dta_ocorrencia", nullable = false)
    private LocalDateTime dataOcorrencia;

    @Enumerated(EnumType.STRING)
    @Column(name = "sta_ocorrencia", nullable = false)
    private StatusOcorrencia status;
}
