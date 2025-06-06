package com.reservahotel.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservahotel.app.entidades.Habitacion;

public interface HabitacionRepositorio extends JpaRepository<Habitacion, Long> {

}
