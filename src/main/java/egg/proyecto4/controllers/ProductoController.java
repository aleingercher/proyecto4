package egg.proyecto4.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import egg.proyecto4.servicios.CervezaServicio;
import egg.proyecto4.servicios.EspirituosaServicio;
import egg.proyecto4.servicios.VinoServicio;

@Controller
@RequestMapping("/producto")
public class ProductoController {
	
	@Autowired
	CervezaServicio cervezaServi;
	
	@Autowired
	VinoServicio vinoServi;
	
	@Autowired
	EspirituosaServicio espirituosaServi;
	
	
}
