package com.reservahotel.app.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.reservahotel.app.entidades.Usuario;
import com.reservahotel.app.repositorios.UsuarioRepositorio;



@Controller
public class UsuarioWeb {

	@Autowired
	private UsuarioRepositorio usuariorepositorio;

	@GetMapping("/registrousuarioadmin")
	public String mostrarFormularioAdmin(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formusuarioadmin";
	}

	@GetMapping("/registro")
	public String mostrarFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formusuario";
	}

	@GetMapping("/verusuarios")
	public String mostrarUsuarios(Model model) {
		List<Usuario> listaUsuarios = usuariorepositorio.findAll();
		model.addAttribute("listaUsuarios", listaUsuarios);
		return "verusuarios";
	}

	@PostMapping("/guardarusuarioadmin")
	public String guardarUsuarios(@ModelAttribute Usuario usuario) {
		usuariorepositorio.save(usuario);
		return "redirect:/verusuarios";
	}

	@PostMapping("/guardarusuario")
	public String guardarUsuario(@ModelAttribute Usuario usuario) {
		usuariorepositorio.save(usuario);
		return "redirect:/";
	}

	@GetMapping("/editarusuario/{id}")
	public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
		Usuario usuario = usuariorepositorio.findById(id)
				.orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
		model.addAttribute("usuario", usuario);
		return "modificarusuario";
	}

	@PostMapping("/actualizarusuario")
	public String actualizarUsuario(@ModelAttribute Usuario usuario) {
		usuariorepositorio.save(usuario);
		return "redirect:/verusuarios";
	}

	@GetMapping("/eliminarusuario/{id}")
	public String eliminarJugador(@PathVariable Long id) {
		usuariorepositorio.deleteById(id);
		return "redirect:/verusuarios";
	}
}
