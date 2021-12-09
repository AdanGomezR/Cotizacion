package com.CotizaCreditos.CotizaCreditos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CotizaCreditos.CotizaCreditos.model.Plazo;
import com.CotizaCreditos.CotizaCreditos.repository.PlazoRepository;

@Controller
@RequestMapping(value="/plazos")
public class PlazoController {
	@Autowired
	private PlazoRepository plazoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Plazo>lista = plazoService.findAll();
		model.addAttribute("plazos", lista);
		return "plazos/listaPlazos";
		}
	
	@PostMapping("/guardar")
	 public String guardar(Plazo plazo,RedirectAttributes attributes) {
		plazoService.save(plazo);
		 attributes.addFlashAttribute("msg", "El plazo se guardo correctamente");
		 return "redirect:/plazos/index";
	 }
	
	@GetMapping("/editar")
	public String editar(Plazo plazo,Model model ) {
		
		model.addAttribute("plazo",plazo);
		return "plazos/formPlazo";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(Plazo plazo,RedirectAttributes attributes) {
		plazoService.delete(plazo);
		attributes.addFlashAttribute("msg","plazo eliminado");
		return "redirect:/plazos/index";
	}
	
	
	@GetMapping("/crear")
	public String crear() {
		
		return "plazos/formPlazos";
	}
	

}
