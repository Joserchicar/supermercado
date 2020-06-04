package com.ipartek.formacion.modelo;

public class Usuario {
	private int id;
	private String nombre;
	private String contrasenia;
	private Rol rol;

	
	public Usuario() {
		super();
		this.id = 0;
		this.nombre = "";
		this.contrasenia="";
		this.rol= new Rol();
		
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

	

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", contrasenia=" + contrasenia + ", rol=" + rol + "]";
	}
	

	
	
	
	

}
