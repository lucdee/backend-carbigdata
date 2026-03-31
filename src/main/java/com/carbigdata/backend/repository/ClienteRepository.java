package com.carbigdata.backend.repository;

import com.carbigdata.backend.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
