package br.com.exactaworks.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.exactaworks.model.Gasto;
import br.com.exactaworks.service.GastoService;

@RestController
public class GastoController {

	@Autowired
	private GastoService service;

	@GetMapping("/")
	public ModelAndView findAll() {
		
		ModelAndView mv = new ModelAndView("/gasto");
		mv.addObject("gastos", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(Optional<Gasto> optional) {
		
		ModelAndView mv = new ModelAndView("/gastoAdd");
		mv.addObject("gasto", optional);

		return mv;
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Gasto gasto, BindingResult result) {
		
		if (result.hasErrors()) {
			return add(gasto);
		}

		service.save(gasto);

		return findAll();
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {
		
		return add(service.findOne(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {
		
		service.delete(id);
		
		return findAll();
	}

	public ModelAndView add(Gasto gasto) {
		
		return null;
	}

}
