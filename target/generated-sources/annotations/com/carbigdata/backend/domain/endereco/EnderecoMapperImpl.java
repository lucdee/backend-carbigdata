package com.carbigdata.backend.domain.endereco;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-31T13:30:24-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoDto toDto(Endereco entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String logradouro = null;
        String bairro = null;
        String cep = null;
        String cidade = null;
        String estado = null;

        id = entity.getId();
        logradouro = entity.getLogradouro();
        bairro = entity.getBairro();
        cep = entity.getCep();
        cidade = entity.getCidade();
        estado = entity.getEstado();

        EnderecoDto enderecoDto = new EnderecoDto( id, logradouro, bairro, cep, cidade, estado );

        return enderecoDto;
    }

    @Override
    public Endereco toEntity(EnderecoDto dto) {
        if ( dto == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setId( dto.id() );
        endereco.setLogradouro( dto.logradouro() );
        endereco.setBairro( dto.bairro() );
        endereco.setCep( dto.cep() );
        endereco.setCidade( dto.cidade() );
        endereco.setEstado( dto.estado() );

        return endereco;
    }
}
