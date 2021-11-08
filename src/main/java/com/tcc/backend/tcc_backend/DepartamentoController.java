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
public class DepartamentoController {
 
	DepartamentoRepository repository;
	
	@GetMapping("/departamento")
	public List<Departamento> getAllDepartamentos(){
		return repository.findAll();
	}
	
	@GetMapping("/departamento/{id}")
	public Departamento getDepartamentoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/departamento")
	public Departamento saveDepartamento(@RequestBody Departamento departamento) {
		return repository.save(departamento);
	}
	
	@DeleteMapping("/departamento/{id}")
	public void deleteDepartamento(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/departamento/{id}")
	public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
		Departamento departamentoToUpdate = repository.getOne(id);
		departamentoToUpdate.setNome(departamento.getNome());
		return repository.save(departamentoToUpdate);
	}
	
}