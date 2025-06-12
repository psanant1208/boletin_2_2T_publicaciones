package com.jacaranda.publicacion;

import com.jacaranda.usuario.Usuario;

public class Recomendacion extends Publicacion{

	private int numeroEstrellas;
	
	public Recomendacion(String texto, Usuario usuario, int numeroEstrellas) {
		super(texto, usuario);
		this.numeroEstrellas=numeroEstrellas;
	}

	@Override
	public boolean valorar(String tipoValoracion) {
		this.valoracion=tipoValoracion;
		return true;
	}

	@Override
	public void setTexto(String texto) {
		this.texto=texto;
	}
}
