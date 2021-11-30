package egg.proyecto4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model, @RequestParam(required = false) String error,@RequestParam(required = false) String nombre, @RequestParam(required = false) String logout) {
		if(error != null) {
			model.addAttribute("error", "El usuario o contraseña son incorrectas");	
		}
		if(nombre != null) {
			model.addAttribute("nombre", nombre);
		}
		
		return"login";
	}

}
