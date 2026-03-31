package com.carbigdata.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
    private Long id;

    @Column(name = "nme_cliente", nullable = false)
    private String nome;

    @Column(name = "dta_nascimento", nullable = false)
    private LocalDate dataNascimento;

    @Column(name = "nro_cpf", nullable = false, unique = true)
    private String cpf;

    @Column(name = "dta_criacao", nullable = false)
    private LocalDateTime dataCriacao;

    @PrePersist
    void prePersist() {
        this.dataCriacao = LocalDateTime.now();
    }
}
