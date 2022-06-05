package com.ProjetoSpringBoot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.repositories.UsuarioRepository;
import com.ProjetoSpringBoot.services.exceptions.DataIntegrityException;
import com.ProjetoSpringBoot.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
		public Usuario buscar(Integer id) {
		Optional<Usuario> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Usuário não encontrado! ID: " + id + ", Tipo: " + Usuario.class.getName()));
		}
	
	public Usuario inserir (Usuario obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public Usuario atualizar(Usuario obj) {
		buscar(obj.getId());
		return repository.save(obj);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir este usuário!");
		}		
	}
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
}
