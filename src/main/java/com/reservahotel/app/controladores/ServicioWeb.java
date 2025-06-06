package com.reservahotel.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservahotel.app.entidades.Servicio;
import com.reservahotel.app.repositorios.HabitacionRepositorio;
import com.reservahotel.app.repositorios.ServicioRepositorio;

@Controller
public class ServicioWeb {
	@Autowired
	private HabitacionRepositorio habitacionRepo;

	@Autowired
	private ServicioRepositorio servicioRepo;

	@GetMapping("/formservicio")
	public String mostrarFormularioServicio(Model model) {
		model.addAttribute("servicio", new Servicio());
		model.addAttribute("habitaciones", habitacionRepo.findAll());
		return "formservicio";
	}

	@PostMapping("/guardarservicio")
	public String guardarServicio(@ModelAttribute Servicio servicio) {
		servicioRepo.save(servicio);
		return "redirect:/verservicios";
	}

	@GetMapping("/verservicios")
	public String listarServicios(Model model) {
		List<Servicio> servicios = servicioRepo.findAll(); // ← AQUÍ se usa List<Servicio>
		model.addAttribute("servicios", servicios);
		return "verservicios";
	}

	@GetMapping("/editarservicio/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
		Servicio servicio = servicioRepo.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("ID de servicio inválido: " + id));

		model.addAttribute("servicio", servicio);
		model.addAttribute("habitaciones", habitacionRepo.findAll());
		return "modificarservicio";
	}

	@PostMapping("/actualizarservicio")
	public String actualizarServicio(@ModelAttribute Servicio servicio) {
		servicioRepo.save(servicio);
		return "redirect:/verservicios";
	}

	@GetMapping("/eliminarservicio/{id}")
	public String eliminarServicio(@PathVariable Long id) {
		servicioRepo.deleteById(id);
		return "redirect:/verservicios";
	}
}
