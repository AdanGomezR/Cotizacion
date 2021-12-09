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

import com.CotizaCreditos.CotizaCreditos.model.Producto;
import com.CotizaCreditos.CotizaCreditos.repository.ProductoRepository;

@Controller
@RequestMapping(value="/producto")
public class ProductoController {

	@Autowired
	private ProductoRepository productoService;
	
	@GetMapping("/index")
	public String mostrarIndex(Model model) {
		List<Producto>lista = productoService.findAll();
		model.addAttribute("productos", lista);
		return "productos/listaProductos";
		}
	
	@PostMapping("/guardar")
	 public String guardar(Producto producto,RedirectAttributes attributes) {
		 productoService.save(producto);
		 attributes.addFlashAttribute("msg", "El producto se guardo correctamente");
		 return "redirect:/productos/index";
	 }
	
	@GetMapping("/editar")
	public String editar(@RequestParam("id") int id_producto,Model model ) {
		Optional<Producto> produc= productoService.findById(id_producto);
		model.addAttribute("producto",produc);
		return "productos/formProducto";
	}
	
	@GetMapping("/eliminar")
	public String eliminar(@RequestParam("id") int id_producto,RedirectAttributes attributes) {
		productoService.delete(productoService.getById(id_producto));
		attributes.addFlashAttribute("msg","producto eliminado");
		return "redirect:/productos/index";
	}
	
	@GetMapping("/buscarId")
	public String buscarId(@RequestParam("id") int id_producto,Model model) {
		model.addAttribute("producto",productoService.getById(id_producto));
		return "productos/listaProductos";
	}
	@GetMapping("/buscarnom")
	public String buscarNombre(@RequestParam("nombre") String nombre_producto,Model model) {
		model.addAttribute("producto",productoService.findByNombre_producto(nombre_producto));
		return "productos/listaProductos";
	}
	@GetMapping("/crear")
	public String crear() {
		
		return "productos/formProducto";
	}
	
}
