package com.jacaranda.memoryStorage;

import com.jacaranda.publicacion.Post;
import com.jacaranda.publicacion.Publicacion;
import com.jacaranda.publicacion.Recomendacion;
import com.jacaranda.publicacion.Tweet;
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
	
	public void addUsuario(String nombre, String contrasenia) {
		Usuario nuevoUsuario = new Usuario(nombre, contrasenia);
		boolean aniadido = false;
		
		for(int i=0; i<NUM_MAXIMO_USUARIOS; i++) {
			if(usuarios[i] == null && !aniadido) {
				usuarios[i] = nuevoUsuario;
				aniadido = true;
			}
		}
	}
	
	public Usuario buscarUsuario(String nombreUsuario) throws MemoryStorageException{
		Usuario usuarioBuscado = null;
		
		for(int i=0; i<NUM_MAXIMO_USUARIOS; i++) {
			if(usuarios[i].getLogin().equals(nombreUsuario)) {
				usuarioBuscado = usuarios[i];
			}
		}
		
		if(usuarioBuscado == null) {
			throw new MemoryStorageException("Usuario no encontrado");
		}
		
		return usuarioBuscado;
	}
	
	/*Tweet*/
	public void addPublicacion(String texto, String nombreUsuario) throws MemoryStorageException {
		boolean aniadida = false;
		
		for(int e=0; e<NUM_MAXIMO_PUBLICACIONES; e++) {
			if(publicaciones[e] == null && !aniadida) {
				publicaciones[e] = new Tweet(texto, buscarUsuario(nombreUsuario));
				aniadida = true;
			}
		}
	}
	
	/*Post*/
	public void addPublicacion(String texto, String nombreUsuario, String tema) throws MemoryStorageException {
		boolean aniadida = false;
		
		for(int e=0; e<NUM_MAXIMO_PUBLICACIONES; e++) {
			if(publicaciones[e] == null && !aniadida) {
				publicaciones[e] = new Post(texto, buscarUsuario(nombreUsuario), tema);
				aniadida = true;
			}
		}
	}
	
	/*Recomendacion*/
	public void addPublicacion(String texto, String nombreUsuario, int numeroEstrellas) throws MemoryStorageException {
		boolean aniadida = false;
		
		for(int e=0; e<NUM_MAXIMO_PUBLICACIONES; e++) {
			if(publicaciones[e] == null && !aniadida) {
				publicaciones[e] = new Recomendacion(texto, buscarUsuario(nombreUsuario), numeroEstrellas);
				aniadida = true;
			}
		}
	}
	
	public String mostrarListaPublicaciones() {
		String cadenaListaPublicaciones = "";
		
		for(int i=0; i<NUM_MAXIMO_PUBLICACIONES; i++) {
			if(publicaciones[i] != null) {
				cadenaListaPublicaciones+=publicaciones[i].toString();
			}
		}
		
		return cadenaListaPublicaciones;
	}
	
	public String mostrarTweets() {
		String cadenaListaTweets = "";
		
		for(int i=0; i<NUM_MAXIMO_PUBLICACIONES; i++) {
			if(publicaciones[i] != null && publicaciones[i] instanceof Tweet) {
				cadenaListaTweets+=publicaciones[i].toString();
			}
		}
		
		return cadenaListaTweets;
	}
	
	public String mostrarPost() {
		String cadenaListaPost = "";
		
		for(int i=0; i<NUM_MAXIMO_PUBLICACIONES; i++) {
			if(publicaciones[i] != null && publicaciones[i] instanceof Post) {
				cadenaListaPost+=publicaciones[i].toString();
			}
		}
		
		return cadenaListaPost;
	}
	
	public String mostrarRecomendaciones() {
		String cadenaListaRecomendaciones = "";
		
		for(int i=0; i<NUM_MAXIMO_PUBLICACIONES; i++) {
			if(publicaciones[i] != null && publicaciones[i] instanceof Recomendacion) {
				cadenaListaRecomendaciones+=publicaciones[i].toString();
			}
		}
		
		return cadenaListaRecomendaciones;
	}
}