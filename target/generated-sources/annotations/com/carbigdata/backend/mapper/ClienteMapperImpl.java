package com.carbigdata.backend.mapper;

import com.carbigdata.backend.dto.request.ClienteRequestDto;
import com.carbigdata.backend.dto.response.ClienteResponseDto;
import com.carbigdata.backend.entity.Cliente;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-31T15:07:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class ClienteMapperImpl implements ClienteMapper {

    @Override
    public ClienteResponseDto toDto(Cliente entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;
        LocalDate dataNascimento = null;
        String cpf = null;
        LocalDateTime dataCriacao = null;

        id = entity.getId();
        nome = entity.getNome();
        dataNascimento = entity.getDataNascimento();
        cpf = entity.getCpf();
        dataCriacao = entity.getDataCriacao();

        ClienteResponseDto clienteResponseDto = new ClienteResponseDto( id, nome, dataNascimento, cpf, dataCriacao );

        return clienteResponseDto;
    }

    @Override
    public Cliente toEntity(ClienteRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Cliente cliente = new Cliente();

        cliente.setNome( request.nome() );
        cliente.setDataNascimento( request.dataNascimento() );
        cliente.setCpf( request.cpf() );

        return cliente;
    }
}
