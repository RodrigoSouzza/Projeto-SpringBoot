package com.ProjetoSpringBoot.domain;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	
	public Usuario(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(name, other.name);
	}	
		
}
