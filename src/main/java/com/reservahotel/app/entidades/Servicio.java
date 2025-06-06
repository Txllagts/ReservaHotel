package com.reservahotel.app.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String tiposervicio;

	private String descripcion;

	private LocalDate fechaprogramada;

	private String estado;

	@OneToOne
	private Habitacion habitacion;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTiposervicio() {
		return tiposervicio;
	}

	public void setTiposervicio(String tiposervicio) {
		this.tiposervicio = tiposervicio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaprogramada() {
		return fechaprogramada;
	}

	public void setFechaprogramada(LocalDate fechaprogramada) {
		this.fechaprogramada = fechaprogramada;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

}
