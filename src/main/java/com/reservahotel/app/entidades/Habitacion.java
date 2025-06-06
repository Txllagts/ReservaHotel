package com.reservahotel.app.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "habitaciones")
public class Habitacion {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private int numero;

	private String tipo;

	private Long precionoche;

	private String estado;

	private String descripcion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Long getPrecionoche() {
		return precionoche;
	}

	public void setPrecionoche(Long precionoche) {
		this.precionoche = precionoche;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
