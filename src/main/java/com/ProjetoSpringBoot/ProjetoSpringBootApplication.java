package com.ProjetoSpringBoot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoSpringBootApplication implements CommandLineRunner {
	
	@Autowired   
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario novoUsuario = new Usuario(null, "Rodrigo", "Meuemail@gmail.com" );
		Usuario segundoUsuario = new Usuario(null, "Souza", "Esseemail@gmail.com" );
		
		usuarioRepository.saveAll(Arrays.asList(novoUsuario,segundoUsuario));
		
	}
 
}
