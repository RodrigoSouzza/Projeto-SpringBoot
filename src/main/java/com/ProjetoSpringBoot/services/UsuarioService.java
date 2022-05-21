package com.ProjetoSpringBoot.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public Usuario buscar(Integer id) {
			Optional<Usuario> obj = repository.findById(id);
			return obj.orElse(null);
	}
	
}
