 package com.ProjetoSpringBoot.dto;

import java.io.Serializable;

import com.ProjetoSpringBoot.domain.Usuario;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private String email;
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		name = obj.getName();
		email = obj.getEmail();
	}
}
