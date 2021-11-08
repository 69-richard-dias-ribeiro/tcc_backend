package com.tcc.backend.tcc_backend;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CargoController {
 
	CargoRepository repository;
	
	@GetMapping("/cargo")
	public List<Cargo> getAllCargos(){
		return repository.findAll();
	}
	
	@GetMapping("/cargo/{id}")
	public Cargo getCargoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/cargo")
	public Cargo saveCargo(@RequestBody Cargo cargo) {
		return repository.save(cargo);
	}
	
	@DeleteMapping("/cargo/{id}")
	public void deleteCargo(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/cargo/{id}")
	public Cargo updateCargo(@PathVariable Long id, @RequestBody Cargo cargo) {
		Cargo departamentoToUpdate = repository.getOne(id);
		departamentoToUpdate.setNome(cargo.getNome());
		return repository.save(departamentoToUpdate);
	}
	
}