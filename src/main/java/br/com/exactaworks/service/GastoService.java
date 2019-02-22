package br.com.exactaworks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.exactaworks.model.Gasto;
import br.com.exactaworks.repository.GastoRepository;

@Service
public class GastoService {

	@Autowired
	private GastoRepository repository;

	public List<Gasto> findAll() {
		
		return repository.findAll();
	}

	public Optional<Gasto> findOne(Long id) {
		
		return repository.findById(id);
	}

	public Gasto save(Gasto gasto) {
		
		return repository.saveAndFlush(gasto);
	}

	public void delete(Long id) {
		
		repository.deleteById(id);
	}

}
