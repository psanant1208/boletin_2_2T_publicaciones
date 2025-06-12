package com.jacaranda.usuario;

import java.util.Objects;

public class Usuario {
	
	private String login;
	private String pass;
	
	public Usuario(String login, String pass) {
		super();
		this.login = login;
		this.pass = pass;
	}
	
	public String getLogin() {
		return login;
	}

	public String getPass() {
		return pass;
	}

	public boolean chechPass(String passIntroducida) {
		return passIntroducida.equals(this.pass);
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(login);
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
		return Objects.equals(login, other.login);
	}
}
