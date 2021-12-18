package egg.proyecto4.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import egg.proyecto4.entidades.Cerveza;
import egg.proyecto4.entidades.Espirituosa;
import egg.proyecto4.entidades.Producto;
import egg.proyecto4.entidades.Vino;
import egg.proyecto4.servicios.CervezaServicio;
import egg.proyecto4.servicios.EspirituosaServicio;
import egg.proyecto4.servicios.ProductoServicio;
import egg.proyecto4.servicios.VinoServicio;

@Controller
@RequestMapping("")
public class MainController {

	@Autowired
	private CervezaServicio cervezaServi;
	
	@Autowired
	private EspirituosaServicio espirituosaServi;
	
	@Autowired
	private VinoServicio vinoServi;
	
	@GetMapping("")
	public String index() {
		
		return "index";
	}
	
	@GetMapping("/home")
	public String home(ModelMap model) {
		
		List<Espirituosa> espirituosa= espirituosaServi.consultarEspirituosas();
		model.addAttribute("espirituosas", espirituosa);
		List<Cerveza> cerveza= cervezaServi.consultarCervezas();
		model.addAttribute("cervezas", cerveza);
		List<Vino> vino= vinoServi.consultarVinos();
		model.addAttribute("vinos", vino);
		
		return "Home";
	}
	
	@GetMapping("/menor")
	public String menor() {
		
		return "menor";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		
		return "nosotros";
	}
}
