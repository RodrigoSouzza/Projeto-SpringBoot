package com.ProjetoSpringBoot.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ProjetoSpringBoot.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuariosResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario>   listar() {
		
		Usuario novoUsuario = new Usuario("Rodrigo","contato.rodrigoom@gmail.com");
		Usuario segundoUsuario = new Usuario("Souza","rodrigoom.contato@hotmail.com");
		Usuario terceiroUsuario = new Usuario("Matheus","Henrique.contato@hotmail.com");

		
		List<Usuario>listaUsuarios = new ArrayList<>();
		listaUsuarios.add(novoUsuario);
		listaUsuarios.add(segundoUsuario);
		listaUsuarios.add(terceiroUsuario);
				
		return listaUsuarios;
	}
	
}
