package egg.proyecto4.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egg.proyecto4.entidades.Usuario;
import egg.proyecto4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	@Autowired
	UsuarioServicio serviUsuario;
	
	@GetMapping("/save")
	public String userSave() {
		
		return"registro";
	}

	
	@PostMapping("/registrarUsuario")
	public String registrar(ModelMap model,String nombre,String apellido, String email,@RequestParam(required = false) String domicilio,@RequestParam(required = false) String detalleDomicilio, String localidad,Date nacimiento, String celular, String clave, String clave2) {
		
		try {
			serviUsuario.RegistrarUsuario(nombre, apellido, email, domicilio, detalleDomicilio, localidad, nacimiento, celular, clave, clave2);
		} catch(Exception e){
			model.put("error", e.getMessage());
			model.put("nombre", nombre);
			model.put("email", email);
			model.put("apellido", apellido);
			model.put("domicilio", domicilio);
			model.put("detalleDom", detalleDomicilio);
			model.put("localidad", localidad);
			model.put("celular", celular);
			return "registro";
		}
		return"home";
	}
	
	@GetMapping("modificar/{id}")
	public String modificar(@PathVariable("id") String id, ModelMap model) {
		
		Usuario usuario =  serviUsuario.findById(id);
		
		model.addAttribute("usuario", usuario);
		
		return "modificarUsuario";
	}
	
	
	
}
