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
	
	public static int CalculaVerificador(String valor) {
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
