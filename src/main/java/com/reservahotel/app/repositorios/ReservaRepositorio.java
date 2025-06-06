package com.reservahotel.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservahotel.app.entidades.Reserva;

public interface ReservaRepositorio extends JpaRepository<Reserva, Long> {

}
