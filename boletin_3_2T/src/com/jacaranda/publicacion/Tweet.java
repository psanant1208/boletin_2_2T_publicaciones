package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Tweet extends Publicacion{

	public Tweet(String texto, Usuario usuario) {
		super(texto, usuario);
	}

	@Override
	public boolean valorar(String tipoValoracion) {
		this.valoracion=tipoValoracion;
		return false;
	}

	@Override
	public void setTexto(String texto) {
		this.texto=texto;
	}

	@Override
	public String toString() {
		return "Tweet [texto=" + texto + ", valoracion=" + valoracion + ", usuario=" + usuario + "]";
	}
}
