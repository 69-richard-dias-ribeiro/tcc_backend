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
public class RestricaoController {
 
	RestricaoRepository repository;
	
	@GetMapping("/restricao")
	public List<Restricao> getAllRestricoes(){
		return repository.findAll();
	}
	
	@GetMapping("/restricao/{id}")
	public Restricao getRestricaoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/restricao")
	public Restricao saveRestricao(@RequestBody Restricao restricao) {
		return repository.save(restricao);
	}
	
	@DeleteMapping("/restricao/{id}")
	public void deleteRestricao(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/restricao/{id}")
	public Restricao updateRestricao(@PathVariable Long id, @RequestBody Restricao restricao) {
		Restricao restricaoToUpdate = repository.getOne(id);
		
		restricaoToUpdate.setTitulo(restricao.getTitulo());
		restricaoToUpdate.setDescricao(restricao.getDescricao());
		restricaoToUpdate.setTipo(restricao.getTipo());
		restricaoToUpdate.setAviso(restricao.getAviso());
		restricaoToUpdate.setNivelRisco(restricao.getNivelRisco());
		restricaoToUpdate.setRestricaoGlobal(restricao.getRestricaoGlobal());
		
		return repository.save(restricaoToUpdate);
	}
	
}