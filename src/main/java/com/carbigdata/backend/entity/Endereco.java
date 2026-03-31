package com.carbigdata.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_endereco")
    private Long id;

    @Column(name = "nme_logradouro", nullable = false)
    private String logradouro;

    @Column(name = "nme_bairro", nullable = false)
    private String bairro;

    @Column(name = "nro_cep", nullable = false)
    private String cep;

    @Column(name = "nme_cidade", nullable = false)
    private String cidade;

    @Column(name = "nme_estado", nullable = false)
    private String estado;
}
