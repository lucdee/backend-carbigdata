package com.carbigdata.backend.mapper;

import com.carbigdata.backend.dto.request.EnderecoRequestDto;
import com.carbigdata.backend.dto.response.EnderecoResponseDto;
import com.carbigdata.backend.entity.Endereco;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-31T15:07:18-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class EnderecoMapperImpl implements EnderecoMapper {

    @Override
    public EnderecoResponseDto toDto(Endereco entity) {
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

        EnderecoResponseDto enderecoResponseDto = new EnderecoResponseDto( id, logradouro, bairro, cep, cidade, estado );

        return enderecoResponseDto;
    }

    @Override
    public Endereco toEntity(EnderecoRequestDto request) {
        if ( request == null ) {
            return null;
        }

        Endereco endereco = new Endereco();

        endereco.setLogradouro( request.logradouro() );
        endereco.setBairro( request.bairro() );
        endereco.setCep( request.cep() );
        endereco.setCidade( request.cidade() );
        endereco.setEstado( request.estado() );

        return endereco;
    }
}
