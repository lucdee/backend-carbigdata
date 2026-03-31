package com.carbigdata.backend.service;

import com.carbigdata.backend.entity.Carro;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

	public List<Carro> listarCarros() {
		return List.of(
			new Carro(1L, "Civic", "Honda", 2022),
			new Carro(2L, "Corolla", "Toyota", 2023),
			new Carro(3L, "Onix", "Chevrolet", 2021)
		);
	}
}
