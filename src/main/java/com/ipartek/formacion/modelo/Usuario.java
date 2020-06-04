package com.ipartek.formacion.modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String contrasenia;
	//TODO Rol usar objeto
	private int idRol;
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasenia="";
		this.idRol=0;
		
	}

	public Usuario(int id,String nombre) {
		this();
		this.id=id;
		this.nombre=nombre;
	}
	public Usuario(String nombre) {
		this();
		this.nombre=nombre;
	}

	public int getId() {
		return id;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", idRol=" + idRol + "]";
	}

	
	
	

}
