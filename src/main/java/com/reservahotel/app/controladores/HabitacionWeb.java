package com.reservahotel.app.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservahotel.app.entidades.Habitacion;
import com.reservahotel.app.repositorios.HabitacionRepositorio;

@Controller
public class HabitacionWeb {
	@Autowired
	private HabitacionRepositorio habitacionRepo;

	@GetMapping("/formhabitacion")
	public String mostrarFormulario(Model model) {
		model.addAttribute("habitacion", new Habitacion());
		return "formhabitacion";
	}

	@PostMapping("/guardarhabitacion")
	public String guardarHabitacion(@ModelAttribute Habitacion habitacion) {
		habitacionRepo.save(habitacion);
		return "redirect:/verhabitaciones";
	}

	@GetMapping("/verhabitaciones")
	public String listarHabitaciones(Model model) {
		model.addAttribute("habitaciones", habitacionRepo.findAll());
		return "verhabitaciones";
	}

	@GetMapping("/habitaciones/editar/{id}")
	public String editarHabitacion(@PathVariable Long id, Model model) {
		Habitacion habitacion = habitacionRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID inválido: " + id));
		model.addAttribute("habitacion", habitacion);
		return "modificarhabitacion";
	}

	@PostMapping("/habitaciones/actualizar")
	public String actualizarHabitacion(@ModelAttribute Habitacion habitacion) {
		habitacionRepo.save(habitacion);
		return "redirect:/verhabitaciones";
	}

	@PostMapping("/habitaciones/eliminar/{id}")
	public String eliminarHabitacion(@PathVariable Long id) {
		habitacionRepo.deleteById(id);
		return "redirect:/verhabitaciones";
	}
}
