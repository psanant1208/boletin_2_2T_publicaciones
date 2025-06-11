package com.jacaranda.publicacion;

import java.time.LocalDateTime;
import java.util.Objects;

import com.jacaranda.usuario.Usuario;

public abstract class Publicacion implements Valorable{
	
	protected String texto;
	private LocalDateTime fechaCreacion;
	protected int valoracion;
	private int codigo;
	private static int codigoSiguiente;
	protected Usuario usuario;
	
	public Publicacion(String texto, Usuario usuario) {
		super();
		this.texto = texto;
		this.usuario = usuario;
		this.fechaCreacion = LocalDateTime.now();
	}

	public String getTexto() {
		return texto;
	}

	public abstract void setTexto(String texto);

	@Override
	public int hashCode() {
		return Objects.hash(fechaCreacion, texto, usuario, valoracion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Publicacion other = (Publicacion) obj;
		return Objects.equals(fechaCreacion, other.fechaCreacion) && Objects.equals(texto, other.texto)
				&& Objects.equals(usuario, other.usuario) && valoracion == other.valoracion;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public boolean valorar(String tipoValoracion) {
		this.valoracion=tipoValoracion;
		return false;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getLoginUsuario() {
		return this.usuario.getLogin();
	}

	@Override
	public String toString() {
		return "Publicacion [texto=" + texto + ", fechaCreacion=" + fechaCreacion + ", valoracion=" + valoracion
				+ ", codigo=" + codigo + ", usuario=" + usuario + "]";
	}
}
