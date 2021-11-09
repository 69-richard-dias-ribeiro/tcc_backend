package com.tcc.backend.tcc_backend;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coordenada {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	
	long longitude;
	long latitude;
	
	@ManyToOne
    @JoinColumn(name="id", nullable=false)
    Area area;
}
