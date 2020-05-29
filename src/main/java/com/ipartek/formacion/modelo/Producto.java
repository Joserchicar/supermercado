package com.ipartek.formacion.modelo;

public class Producto {

	private int id;
	private String nombre;
	private String imagen;
	private float precio;
	
	
	public Producto() {
		super();
		this.id=0;
		this.nombre="";	
		this.imagen="";
		this.precio=0;
		
	}
	public Producto(String nombre) {
		this();
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}


	public void setImagen(String imagen) {
		this.imagen = imagen;
	}


	public float getPrecio() {
		return precio;
	}


	public void setPrecio(float precio) {
		this.precio = precio;
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
		return "Producto [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", precio=" + precio + "]";
	}


	
	
	
	
}
