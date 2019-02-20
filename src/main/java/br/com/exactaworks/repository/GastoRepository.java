package br.com.exactaworks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.exactaworks.model.Gasto;

public interface GastoRepository extends JpaRepository<Gasto, Long > {

}
