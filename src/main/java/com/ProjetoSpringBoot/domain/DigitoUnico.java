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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class DigitoUnico implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@JsonBackReference
	@ManyToMany
	@JoinTable(name = "USUARIO_DIGITOUNICO",
		joinColumns = @JoinColumn(name = "digitoUnico_id"),
		inverseJoinColumns = @JoinColumn(name= "usuario_id")
			)
	
	private List<Usuario> usuarios = new ArrayList<>();
		
	static int CalculaVerificador(String valor) {
		int soma = 0;
		int resto = 0;
		int digitoVerificador = 0;
		String [] numeros = new String[valor.length() +1];
		int multiplicador = 2;
		
		for (int i = valor.length(); i > 0; i --) {
			if(multiplicador > 9) {
				multiplicador = 2;
				numeros[i] = String.valueOf(Integer.valueOf(valor.substring(i -1, i)) * multiplicador);
				multiplicador ++;
			}else {
				numeros[i] = String.valueOf(Integer.valueOf(valor.substring(i - 1, i)) * multiplicador);
				multiplicador ++;
			}
		}
		
		for(int i = numeros.length; i > 0; i--) {
			if(numeros[i -1] != null) {
				soma += Integer.valueOf(numeros[i -1]);
			}
		}
		
		resto = soma % 11;
		digitoVerificador = 11 - resto;
		if(digitoVerificador > 9 || digitoVerificador == 0) {
			digitoVerificador = 1;
		}
		return digitoVerificador;
		
		}		
}
