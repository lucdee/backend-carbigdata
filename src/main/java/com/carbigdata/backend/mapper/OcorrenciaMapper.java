package com.carbigdata.backend.mapper;

import com.carbigdata.backend.entity.FotoOcorrencia;
import com.carbigdata.backend.domain.foto.FotoOcorrenciaDto;
import com.carbigdata.backend.domain.ocorrencia.OcorrenciaDto;
import com.carbigdata.backend.entity.Ocorrencia;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OcorrenciaMapper {

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "enderecoId", source = "endereco.id")
    OcorrenciaDto toDto(Ocorrencia entity);

    @Mapping(target = "ocorrenciaId", source = "ocorrencia.id")
    FotoOcorrenciaDto toDto(FotoOcorrencia foto);
}
