package com.tcc.backend.tcc_backend;

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
public class UltimaLocalizacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	String matricula;
	double ultimaLongitude;
	double ultimaLatitude;
}
