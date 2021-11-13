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
public class UltimaLocalizacaoController {
 
	UltimaLocalizacaoRepository repository;
	
	@GetMapping("/ultimaslocalizacoes")
	public List<UltimaLocalizacao> getAllUltimasLocalizacoes(){
		return repository.findAll();
	}
	
	@GetMapping("/ultimaslocalizacoes/{id}")
	public UltimaLocalizacao getUltimaLocalizacaoById(@PathVariable Long id) {
		return repository.findById(id).get();
	}
	
	@PostMapping("/ultimaslocalizacoes")
	public UltimaLocalizacao saveUltimaLocalizacao(@RequestBody UltimaLocalizacao ultimaLocalizacao) {
		return repository.save(ultimaLocalizacao);
	}
	
	@DeleteMapping("/ultimaslocalizacoes/{id}")
	public void deleteUltimaLocalizacao(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@PutMapping("/ultimaslocalizacoes")
	public UltimaLocalizacao updateUltimaLocalizacao(@RequestBody UltimaLocalizacao ultimaLocalizacao) {
		// UltimaLocalizacao ultimaLocalizacaoToUpdate = repository.getOne(id);
		// ultimaLocalizacaoToUpdate.setUltimaLongitude(ultimaLocalizacao.getUltimaLongitude());
		// ultimaLocalizacaoToUpdate.setUltimaLatitude(ultimaLocalizacao.getUltimaLatitude());
		// return repository.save(ultimaLocalizacaoToUpdate);
		
		//verifica se já existe; se sim, atualiza esse que já existe; se não, cria um novo
		List<UltimaLocalizacao>localizacoes = repository.findAll();
		
		boolean jaExiste = false;
		UltimaLocalizacao localizacaoJaExistente = null;
		
		for (int i = 0; i < localizacoes.size(); i++) {
			if (localizacoes.get(i).matricula.equals(ultimaLocalizacao.matricula)) {
				jaExiste = true;
				localizacaoJaExistente = localizacoes.get(i);
			}
		}
		
		if (jaExiste) {
			UltimaLocalizacao ultimaLocalizacaoToUpdate = repository.getOne(localizacaoJaExistente.id);
			ultimaLocalizacaoToUpdate.setUltimaLongitude(ultimaLocalizacao.getUltimaLongitude());
			ultimaLocalizacaoToUpdate.setUltimaLatitude(ultimaLocalizacao.getUltimaLatitude());
			return repository.save(ultimaLocalizacaoToUpdate);
		} else {
			return repository.save(ultimaLocalizacao);
		}
	}
	
	@GetMapping("/preenchercomdadosiniciais")
	public void preencherComDadosIniciais() {
		repository.deleteAll();
		
		UltimaLocalizacao ultimaLocalizacao14378 = new UltimaLocalizacao();
		UltimaLocalizacao ultimaLocalizacao13912 = new UltimaLocalizacao();
		
		ultimaLocalizacao14378.setMatricula("14378");
		ultimaLocalizacao14378.setUltimaLongitude(-47.016076);
		ultimaLocalizacao14378.setUltimaLatitude(-22.718027);
		ultimaLocalizacao13912.setMatricula("13912");
		ultimaLocalizacao13912.setUltimaLongitude(-47.016451);
		ultimaLocalizacao13912.setUltimaLatitude(-22.717668);
		
		repository.save(ultimaLocalizacao14378);
		repository.save(ultimaLocalizacao13912);
	}
	
	@GetMapping("/limpartodos")
	public void limparTodos() {
		repository.deleteAll();
	}
	
}