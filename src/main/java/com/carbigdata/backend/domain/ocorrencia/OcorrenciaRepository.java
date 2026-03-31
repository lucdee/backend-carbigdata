package com.carbigdata.backend.domain.ocorrencia;

import com.carbigdata.backend.entity.Ocorrencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long> {
}
