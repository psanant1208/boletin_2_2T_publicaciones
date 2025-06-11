package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.usuario.Usuario;

public class MemoryStorage {
	
	private static final int NUM_MAXIMO_USUARIOS=15;
	private static final int NUM_MAXIMO_PUBLICACIONES=50;
	private int numUsuariosActuales;
	private int numPublicacionesActuales;
	private Usuario[] usuarios;
	private Publicacion[] publicaciones;
	
	public MemoryStorage() {
		super();
		this.numUsuariosActuales=0;
		this.numPublicacionesActuales=0;
		this.usuarios = new Usuario[NUM_MAXIMO_USUARIOS];
		this.publicaciones = new Publicacion[NUM_MAXIMO_PUBLICACIONES];
	}
	
	private int posicionUsuario(String nombreUsuario) {
		int numPosicion = 0;
		
		for(int i=0; i<usuarios.length; i++) {
			if(usuarios[i].getLogin().equals(nombreUsuario)) {
				numPosicion = i;
			}
		}
		
		return numPosicion;
	}
	
	
}
