package com.carbigdata.backend.service.impl;

import com.carbigdata.backend.entity.Carro;
import com.carbigdata.backend.service.CarroService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CarroServiceImpl implements CarroService {

    @Override
    public List<Carro> listarCarros() {
        return List.of(
                new Carro(1L, "Civic", "Honda", 2022),
                new Carro(2L, "Corolla", "Toyota", 2023),
                new Carro(3L, "Onix", "Chevrolet", 2021)
        );
    }
}
