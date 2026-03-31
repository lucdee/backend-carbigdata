package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.domain.cliente.Cliente;
import com.carbigdata.backend.domain.endereco.Endereco;
import jakarta.persistence.*;
import java.time.LocalDateTime;

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

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Endereco getEndereco() { return endereco; }
    public void setEndereco(Endereco endereco) { this.endereco = endereco; }
    public LocalDateTime getDataOcorrencia() { return dataOcorrencia; }
    public void setDataOcorrencia(LocalDateTime dataOcorrencia) { this.dataOcorrencia = dataOcorrencia; }
    public StatusOcorrencia getStatus() { return status; }
    public void setStatus(StatusOcorrencia status) { this.status = status; }
}
