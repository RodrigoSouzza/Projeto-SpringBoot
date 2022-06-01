package com.ProjetoSpringBoot;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ProjetoSpringBoot.domain.DigitoUnico;
import com.ProjetoSpringBoot.domain.Usuario;
import com.ProjetoSpringBoot.repositories.DigitoUnicoRepository;
import com.ProjetoSpringBoot.repositories.UsuarioRepository;

@SpringBootApplication
public class ProjetoSpringBootApplication implements CommandLineRunner {
	
	@Autowired   
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DigitoUnicoRepository digitoUnicoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario primeiroUsuario = new Usuario(null, "Rodrigo", "Meuemail@gmail.com" , null);
		Usuario segundoUsuario = new Usuario(null, "Souza", "Esseemail@gmail.com" , null);
		Usuario terceiroUsuario = new Usuario(null, "Maciel", "sememail@gmail.com", null );

		DigitoUnico primeiroDigito = new DigitoUnico ();
		DigitoUnico segundoDigito = new DigitoUnico ();
		DigitoUnico terceiroDigito = new DigitoUnico ();
		
		/*
		primeiroUsuario.getDigitosUnicos().addAll(Arrays.asList(primeiroDigito, segundoDigito, terceiroDigito));
		segundoUsuario.getDigitosUnicos().addAll(Arrays.asList(segundoDigito, terceiroDigito));
		terceiroUsuario.getDigitosUnicos().addAll(Arrays.asList(terceiroDigito));
		
		primeiroDigito.getUsuarios().addAll(Arrays.asList(primeiroUsuario));
		segundoDigito.getUsuarios().addAll(Arrays.asList(primeiroUsuario, segundoUsuario));
		terceiroDigito.getUsuarios().addAll(Arrays.asList(primeiroUsuario, terceiroUsuario));		
			
		*/
				
		usuarioRepository.saveAll(Arrays.asList(primeiroUsuario,segundoUsuario, terceiroUsuario));
		digitoUnicoRepository.saveAll(Arrays.asList(primeiroDigito, segundoDigito, terceiroDigito));
		
	}
 
}
