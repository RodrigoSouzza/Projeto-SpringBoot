package com.ProjetoSpringBoot.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable  Integer id) {
		Usuario obj =  service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Usuario obj){
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	 
	@RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario obj, @PathVariable  Integer id){
		obj.setId(id);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build(); 				
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable  Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
