package com.reservahotel.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservahotel.app.entidades.Hotel;
import com.reservahotel.app.entidades.Usuario;
import com.reservahotel.app.repositorios.HotelRepositorio;
import com.reservahotel.app.repositorios.UsuarioRepositorio;

import jakarta.servlet.http.HttpSession;

@Controller
public class HotelWeb {

	@Autowired
	private HotelRepositorio hotelrepositorio;

	@GetMapping("/registrohotel")
	public String mostrarFormulario(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "formhotel";
	}

	@PostMapping("/guardarhotel")
	public String guardarHotel(@ModelAttribute Hotel hotel) {
		hotelrepositorio.save(hotel);
		return "redirect:/verhoteles";
	}

	@GetMapping("/verhoteles")
	public String mostrarHoteles(Model model) {
		List<Hotel> listaHoteles = hotelrepositorio.findAll();
		model.addAttribute("listaHoteles", listaHoteles);
		return "verhoteles";
	}

	@GetMapping("/editarhotel/{id}")
	public String editarHotel(@PathVariable Long id, Model model) {
		Hotel hotel = hotelrepositorio.findById(id).orElse(null);
		model.addAttribute("hotel", hotel);
		return "modificarhotel";
	}

	@PostMapping("/actualizarhotel")
	public String modificarHotel(@ModelAttribute Hotel hotel) {
		hotelrepositorio.save(hotel);
		return "redirect:/verhoteles";
	}

	@PostMapping("/eliminarhotel/{id}")
	public String eliminarHotel(@PathVariable Long id) {
		hotelrepositorio.deleteById(id);
		return "redirect:/verhoteles";
	}
}
