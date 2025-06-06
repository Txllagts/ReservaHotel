package com.reservahotel.app.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservahotel.app.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	Usuario findByEmailAndPassword(String email, String password);

}
