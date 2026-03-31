package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.domain.foto.FotoOcorrencia;
import com.carbigdata.backend.domain.foto.FotoOcorrenciaDto;
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
