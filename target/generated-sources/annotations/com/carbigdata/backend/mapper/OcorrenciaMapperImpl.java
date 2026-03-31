package com.carbigdata.backend.mapper;

import com.carbigdata.backend.dto.response.FotoOcorrenciaResponseDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import com.carbigdata.backend.entity.Cliente;
import com.carbigdata.backend.entity.Endereco;
import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.entity.Ocorrencia;
import com.carbigdata.backend.entity.StatusOcorrencia;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-03-31T14:07:10-0300",
    comments = "version: 1.6.3, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
@Component
public class OcorrenciaMapperImpl implements OcorrenciaMapper {

    @Override
    public OcorrenciaResponseDto toDto(Ocorrencia entity) {
        if ( entity == null ) {
            return null;
        }

        Long clienteId = null;
        Long enderecoId = null;
        Long id = null;
        LocalDateTime dataOcorrencia = null;
        StatusOcorrencia status = null;

        clienteId = entityClienteId( entity );
        enderecoId = entityEnderecoId( entity );
        id = entity.getId();
        dataOcorrencia = entity.getDataOcorrencia();
        status = entity.getStatus();

        OcorrenciaResponseDto ocorrenciaResponseDto = new OcorrenciaResponseDto( id, clienteId, enderecoId, dataOcorrencia, status );

        return ocorrenciaResponseDto;
    }

    @Override
    public FotoOcorrenciaResponseDto toDto(FotoOcorrencia foto) {
        if ( foto == null ) {
            return null;
        }

        Long ocorrenciaId = null;
        Long id = null;
        LocalDateTime dataCriacao = null;
        String pathBucket = null;
        String hash = null;

        ocorrenciaId = fotoOcorrenciaId( foto );
        id = foto.getId();
        dataCriacao = foto.getDataCriacao();
        pathBucket = foto.getPathBucket();
        hash = foto.getHash();

        FotoOcorrenciaResponseDto fotoOcorrenciaResponseDto = new FotoOcorrenciaResponseDto( id, ocorrenciaId, dataCriacao, pathBucket, hash );

        return fotoOcorrenciaResponseDto;
    }

    private Long entityClienteId(Ocorrencia ocorrencia) {
        Cliente cliente = ocorrencia.getCliente();
        if ( cliente == null ) {
            return null;
        }
        return cliente.getId();
    }

    private Long entityEnderecoId(Ocorrencia ocorrencia) {
        Endereco endereco = ocorrencia.getEndereco();
        if ( endereco == null ) {
            return null;
        }
        return endereco.getId();
    }

    private Long fotoOcorrenciaId(FotoOcorrencia fotoOcorrencia) {
        Ocorrencia ocorrencia = fotoOcorrencia.getOcorrencia();
        if ( ocorrencia == null ) {
            return null;
        }
        return ocorrencia.getId();
    }
}
