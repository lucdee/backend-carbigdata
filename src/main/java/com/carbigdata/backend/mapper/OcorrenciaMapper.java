package com.carbigdata.backend.mapper;

import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.dto.response.FotoOcorrenciaResponseDto;
import com.carbigdata.backend.dto.response.OcorrenciaResponseDto;
import com.carbigdata.backend.entity.Ocorrencia;
import org.springframework.stereotype.Component;

@Component
public class OcorrenciaMapper {

    public OcorrenciaResponseDto toDto(Ocorrencia entity) {
        if (entity == null) {
            return null;
        }

        Long clienteId = entity.getCliente() != null ? entity.getCliente().getId() : null;
        Long enderecoId = entity.getEndereco() != null ? entity.getEndereco().getId() : null;

        return new OcorrenciaResponseDto(
                entity.getId(),
                clienteId,
                enderecoId,
                entity.getDataOcorrencia(),
                entity.getStatus()
        );
    }

    public FotoOcorrenciaResponseDto toDto(FotoOcorrencia foto) {
        if (foto == null) {
            return null;
        }

        Long ocorrenciaId = foto.getOcorrencia() != null ? foto.getOcorrencia().getId() : null;

        return new FotoOcorrenciaResponseDto(
                foto.getId(),
                ocorrenciaId,
                foto.getDataCriacao(),
                foto.getPathBucket(),
                foto.getHash()
        );
    }
}
