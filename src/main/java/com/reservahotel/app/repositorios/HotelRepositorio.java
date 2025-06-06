package com.reservahotel.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservahotel.app.entidades.Hotel;

public interface HotelRepositorio extends JpaRepository<Hotel, Long> {

}
