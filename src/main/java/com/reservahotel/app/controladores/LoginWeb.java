package com.reservahotel.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservahotel.app.entidades.Hotel;
import com.reservahotel.app.entidades.Reserva;
import com.reservahotel.app.entidades.Servicio;
import com.reservahotel.app.entidades.Usuario;
import com.reservahotel.app.repositorios.HabitacionRepositorio;
import com.reservahotel.app.repositorios.UsuarioRepositorio;

import jakarta.servlet.http.HttpSession;

@Controller
public class LoginWeb {

	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	@Autowired
	private HabitacionRepositorio habitacionrepositorio;

	@PostMapping("/login")
	public String login(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {

		Usuario usuario = usuariorepositorio.findByEmailAndPassword(email, password);

		if (usuario != null) {
			session.setAttribute("usuario", usuario);

			if ("admin".equals(usuario.getRol())) {
				model.addAttribute("hotel", new Usuario());
				return "formusuarioadmin";
			} else if ("gerente".equals(usuario.getRol())) {
				model.addAttribute("hotel", new Hotel());
				return "formhotel";
			} else if ("recepcionista".equals(usuario.getRol())) {
				model.addAttribute("reserva", new Reserva());
				model.addAttribute("habitaciones", habitacionrepositorio.findAll());
				model.addAttribute("usuarios", usuariorepositorio.findAll());
				return "formreserva";
			} else if ("cliente".equals(usuario.getRol())) {
				model.addAttribute("reserva", new Reserva());
				model.addAttribute("habitaciones", habitacionrepositorio.findAll());
				model.addAttribute("usuarios", usuariorepositorio.findAll());
				return "formreserva";
			} else if ("prestador".equals(usuario.getRol())) {
				model.addAttribute("servicio", new Servicio());
				model.addAttribute("habitaciones", habitacionrepositorio.findAll());
				return "formservicio";
			} else {
				model.addAttribute("error", "Rol no autorizado");
				return "index";
			}
		} else {
			model.addAttribute("error", "Credenciales incorrectas");
			return "index";
		}
	}

}
