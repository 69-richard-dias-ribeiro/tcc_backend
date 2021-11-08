package com.tcc.backend.tcc_backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Restricao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	@Column(unique=true)
	String titulo;
	
	String descricao;
	int tipo; //1: acesso restrito; 2: distanciamento social
	String aviso;
	int nivelRisco; //1: baixo; 2: médio; 3: alto
	int restricaoGlobal;//1: válido para todos os colaboradores; 0: o contrário do 1 ;)
}
