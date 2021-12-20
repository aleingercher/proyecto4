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
import egg.proyecto4.errores.errores;
import egg.proyecto4.servicios.EnvioMail;
import egg.proyecto4.servicios.UsuarioServicio;

@Controller
@RequestMapping("/user")
public class UsuarioController {
	
	private Integer Codigo;
	
	@Autowired
	UsuarioServicio serviUsuario;
	
	@Autowired
	EnvioMail envioMail;
	
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
		return"redirect:/home";
	}
	
	@GetMapping("modificar/{id}")
	public String modificar(@PathVariable("id") String id, ModelMap model) {
		
		Usuario usuario =  serviUsuario.findById(id);
		
		model.addAttribute("usuario", usuario);
		
		return "modificarUsuario";
	}
	
	
	@GetMapping("/recuperarClave")
	public String recuperarClave(ModelMap model) {
		
		String codigo = null;
		model.addAttribute("codigo", codigo);
		String bandera = null;
		model.addAttribute("bandera", bandera);
		
		return"recuperacionClave";
	}
	
	@GetMapping("/cargarCodigo")
	public String cargarCodigo(ModelMap model, String email) {
		
		
		
		 try {
			envioMail.sendEmailClave(email);
			String codigo = "var";
			model.addAttribute("codigo", codigo);
			model.addAttribute("email", email);
		} catch (errores e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return"recuperacionClave";
	}
	
	@GetMapping("/cambiarClave/{email}")
	public String cambiarClave(ModelMap model,@PathVariable("email") String email, Integer codigo) {
		//validar codigo
		Usuario usuario = serviUsuario.findByEmail(email);
		
		if(usuario.getCodigo().equals(codigo)) {
		
		String var = "variable";
		model.addAttribute("codigo", var);
		String variable = null;
		model.addAttribute("email", variable);
		String bandera = "bandera";
		model.addAttribute("bandera", bandera);
		model.addAttribute("emaill", email);
		return"recuperacionClave";
		} else {
			model.addAttribute("error" , "El codigo ingresado es incorrecto");
			String bandera = null;
			model.addAttribute("bandera", bandera);
			model.addAttribute("codigo", Codigo);
			model.addAttribute("email", email);
			return"recuperacionClave";
		}
	}
	
	@PostMapping("/modificarClave/{email}")
	public String modificarClave(ModelMap model,@PathVariable("email") String email, String clave, String clave2) {
		
		try {
			serviUsuario.ModificarClave(email, clave, clave2);
		} catch (errores e) {
			model.addAttribute("error" , e.getMessage());
			return"redirect:/user/recuperarClave";
		}		
		
		return"redirect:/login";
	}
}
