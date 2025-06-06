package com.reservahotel.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservahotel.app.entidades.Servicio;

public interface ServicioRepositorio extends JpaRepository<Servicio, Long> {

}
