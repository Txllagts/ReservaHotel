package com.reservahotel.app.entidades;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "hoteles")
public class Hotel {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nombre;

	private String direccion;

	private String ciudad;

	private String pais;

	private String telefono;

	private String email;

	private String descripcion;

	@OneToMany
	@JoinColumn(name = "id_hotel")
	private List<Habitacion> habicaciones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Habitacion> getHabicaciones() {
		return habicaciones;
	}

	public void setHabicaciones(List<Habitacion> habicaciones) {
		this.habicaciones = habicaciones;
	}

}
