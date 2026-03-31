package com.carbigdata.backend.controller;

import com.carbigdata.backend.service.CarroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarroController {

	private final CarroService carroService;

	public CarroController(CarroService carroService) {
		this.carroService = carroService;
	}

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("carros", carroService.listarCarros());
		return "carros";
	}
}
