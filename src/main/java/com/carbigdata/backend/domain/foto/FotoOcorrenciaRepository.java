package com.carbigdata.backend.domain.foto;

import com.carbigdata.backend.entity.FotoOcorrencia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FotoOcorrenciaRepository extends JpaRepository<FotoOcorrencia, Long> {
    Page<FotoOcorrencia> findByOcorrenciaId(Long ocorrenciaId, Pageable pageable);
}
