 package com.ProjetoSpringBoot.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.dto.UsuarioDTO;
import com.ProjetoSpringBoot.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> buscarAll() {
		List<Usuario> list =  service.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Usuario> buscar(@PathVariable  Integer id) {
		Usuario obj =  service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Usuario obj){
		String digit = obj.getDigitos();
		int result = UsuarioService.CalculaVerificador(digit);
		obj.setResultado(result);
		obj = service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
	return ResponseEntity.created(uri).build();
	}
	 
	@RequestMapping(value = "/{id}",  method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Usuario obj, @PathVariable  Integer id){
		obj.setId(id);
		String digit = obj.getDigitos();
		int result = UsuarioService.CalculaVerificador(digit);
		obj.setResultado(result);
		obj = service.atualizar(obj);
		return ResponseEntity.noContent().build(); 				
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable  Integer id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}	
}
