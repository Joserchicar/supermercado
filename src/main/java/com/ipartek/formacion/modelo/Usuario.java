package com.ipartek.formacion.modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String contrasenia;
	private int id_rol;
	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasenia="";
		this.id_rol=0;
		
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
		return "Alumno [id=" + id + ", nombre=" + nombre + "]";
	}
	

}
