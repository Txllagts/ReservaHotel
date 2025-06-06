package com.reservahotel.app.entidades;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "reservas")
public class Reserva {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private LocalDate fechainicio;

	private LocalDate fechafin;

	private String estado;

	private LocalDate fechareserva;

	@OneToOne
	private Habitacion habitacion;

	@OneToOne
	private Usuario usuarios;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(LocalDate fechainicio) {
		this.fechainicio = fechainicio;
	}

	public LocalDate getFechafin() {
		return fechafin;
	}

	public void setFechafin(LocalDate fechafin) {
		this.fechafin = fechafin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public LocalDate getFechareserva() {
		return fechareserva;
	}

	public void setFechareserva(LocalDate fechareserva) {
		this.fechareserva = fechareserva;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	}

	public Usuario getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuario usuarios) {
		this.usuarios = usuarios;
	}

}
