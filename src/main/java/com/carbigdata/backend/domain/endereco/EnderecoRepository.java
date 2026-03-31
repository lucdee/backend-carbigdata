package com.carbigdata.backend.domain.endereco;

import com.carbigdata.backend.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
