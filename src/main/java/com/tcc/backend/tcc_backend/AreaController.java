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
public class AreaController {
 
	AreaRepository repository;
	
	@GetMapping("/area")
	public List<Area> getAllAreas(){
		return repository.findAll();
	}
	
	@GetMapping("/area/{id}")
	public Area getAreaById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/area")
	public Area saveArea(@RequestBody Area area) {
		return repository.save(area);
	}
	
	@DeleteMapping("/area/{id}")
	public void deleteArea(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/area/{id}")
	public Area updateArea(@PathVariable Long id, @RequestBody Area area) {
		Area areaToUpdate = repository.getOne(id);
		areaToUpdate.setTitulo(area.getTitulo());
		areaToUpdate.setDescricao(area.getDescricao());
		
		for(int i = 0; i < area.getCoordenada().size(); i++) {
			areaToUpdate.getCoordenada().add(area.getCoordenada().get(i));
		}
		
		return repository.save(areaToUpdate);
	}
	
}