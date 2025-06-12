package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Post extends Publicacion {

	private int numeroLecturas;
	private String tema;
	
	public Post(String texto, Usuario usuario, String tema) {
		super(texto, usuario);
		this.tema=tema;
		this.numeroLecturas=0;
	}

	@Override
	public boolean valorar(String tipoValoracion) {
		this.valoracion=tipoValoracion;
		return false;
	}

	@Override
	public void setTexto(String texto) {
		// TODO Auto-generated method stub

	}
}
