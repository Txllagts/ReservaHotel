package com.reservahotel.app.controladores;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservahotel.app.entidades.Reserva;
import com.reservahotel.app.repositorios.HabitacionRepositorio;
import com.reservahotel.app.repositorios.ReservaRepositorio;
import com.reservahotel.app.repositorios.UsuarioRepositorio;

@Controller
public class ReservaWeb {
	@Autowired
	private ReservaRepositorio reservarepositorio;

	@Autowired
	private HabitacionRepositorio habitacionrepositorio;

	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	@GetMapping("/formreserva")
	public String mostrarFormularioReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		model.addAttribute("habitaciones", habitacionrepositorio.findAll());
		model.addAttribute("usuarios", usuariorepositorio.findAll());
		return "formreserva";
	}

	@PostMapping("/guardarreserva")
	public String guardarReserva(@ModelAttribute Reserva reserva) {
		reserva.setFechareserva(LocalDate.now());
		reservarepositorio.save(reserva);
		return "redirect:/verreservas";
	}

	@GetMapping("/verreservas")
	public String listarReservas(Model model) {
		List<Reserva> reservas = reservarepositorio.findAll();
		model.addAttribute("reservas", reservas);
		return "verreservas";
	}

	@GetMapping("/reservas/editar/{id}")
	public String editarReserva(@PathVariable Long id, Model model) {
		Reserva reserva = reservarepositorio.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID no válido"));
		model.addAttribute("reserva", reserva);
		model.addAttribute("habitaciones", habitacionrepositorio.findAll());
		model.addAttribute("usuarios", usuariorepositorio.findAll());
		return "modificarreserva";
	}

	@PostMapping("/reservas/actualizar")
	public String actualizarReserva(@ModelAttribute Reserva reserva) {
		reservarepositorio.save(reserva);
		return "redirect:/verreservas";
	}

	@GetMapping("/reservas/eliminar/{id}")
	public String eliminarReserva(@PathVariable Long id) {
		reservarepositorio.deleteById(id);
		return "redirect:/verreservas";
	}

}
