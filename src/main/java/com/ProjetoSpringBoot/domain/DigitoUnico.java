package com.ProjetoSpringBoot.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
public class DigitoUnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany
	@JoinTable(name = "LISTA_DIGITOUNICO",
		joinColumns = @JoinColumn(name = "lista_id"),
		inverseJoinColumns = @JoinColumn(name= "usuario_id")
			)
	
	private List<Usuario> usuarios = new ArrayList<>();
	
	public static int CalculaDigitoUnico(int numero) {
		int soma = 0;		
		while( numero > 0 || soma > 9) {
			if(numero == 0) {
				numero = soma;
				soma = 0;
			}
			soma += numero% 10;
			numero/=10;
		}
		return numero;
	}	
}
