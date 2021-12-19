package egg.proyecto4.controllers;

import java.io.IOException;



import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import egg.proyecto4.entidades.Cerveza;
import egg.proyecto4.entidades.Espirituosa;
import egg.proyecto4.entidades.Producto;
import egg.proyecto4.entidades.Vino;

import egg.proyecto4.errores.errores;
import egg.proyecto4.servicios.CervezaServicio;
import egg.proyecto4.servicios.EspirituosaServicio;
import egg.proyecto4.servicios.ProductoServicio;
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
	
	@Autowired
	ProductoServicio productoServi;

	
	//ENDPOINT VISTA CARGARPRODUCTOS
	
	@GetMapping("/cargarProductos")
	public String cargaProductos() {
		
		return "cargarProductos"; 	
	}
	
	//ENDPOINTS GET AND POST PARA GUARDAR PRODUCTOS
	
	@GetMapping("/cervezaSave")
	public String cerveza() {
		
		
		
		return "cargaCerveza"; 	//Estas vistan se retornan a ellas mismas.
	}
	
	@GetMapping("/vinoSave")
	public String vino() {
		return "cargaVino";		//Estas vistan se retornan a ellas mismas.
	}
	
	@GetMapping("/espirituosaSave")
	public String espirituosa() {
		
		return "cargaEspirituosa";	//Estas vistan se retornan a ellas mismas.
	}
	
	@PostMapping("/cervezaSave")
	public String cerveza (ModelMap model, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock, String descripcion,String varietal, String envase, String tipo, String origen) {
		String img = null;
		if (!imagen.isEmpty()) {
			// Path directorioImg = Paths.get("src//main//resources//static//imagenes");
			String rutaAbs = "C://Producto//recursos";
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCmpleta = Paths.get(rutaAbs + "//" + imagen.getOriginalFilename());
				Files.write(rutaCmpleta, bytesImg);
				img = imagen.getOriginalFilename();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			cervezaServi.guardarCerveza(descripcion, envase, varietal, img, marca, origen, otrasmarca, tipo, precio, stock);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			model.put("precio", precio);
			model.put("stock", stock);
			model.put("descripcion", descripcion);
			return "cargaCerveza";
		}
		return "redirect:/home";
	}
	
	@PostMapping("/vinoSave")
	public String vino (ModelMap model, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock,          @RequestParam(required = false) String descripcion, String bodega, String varietal, String envase, String tipo, String origen) {
		String img = null;
		if (!imagen.isEmpty()) {
			// Path directorioImg = Paths.get("src//main//resources//static//imagenes");
			String rutaAbs = "C://Producto//recursos";
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCmpleta = Paths.get(rutaAbs + "//" + imagen.getOriginalFilename());
				Files.write(rutaCmpleta, bytesImg);
				img = imagen.getOriginalFilename();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
                
		try {
			vinoServi.guardarVino( descripcion, envase, varietal, bodega, img, marca, origen, otrasmarca, tipo, precio, stock);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			model.put("precio", precio);
			model.put("stock", stock);
			model.put("descripcion", descripcion);
			return "cargaVino";
		}
                
		return "redirect:/home";
	}
	
	@PostMapping("/espirituosaSave")
	public String espirituosa (ModelMap model, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock, String descripcion, String envase, String tipo, String origen) {
		String img = null;
		if (!imagen.isEmpty()) {
			// Path directorioImg = Paths.get("src//main//resources//static//imagenes");
			String rutaAbs = "C://Producto//recursos";
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCmpleta = Paths.get(rutaAbs + "//" + imagen.getOriginalFilename());
				Files.write(rutaCmpleta, bytesImg);
				img = imagen.getOriginalFilename();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		try {
			espirituosaServi.guardarEspirituosa(descripcion, envase, img, marca, origen, otrasmarca, tipo, precio, stock);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			model.put("precio", precio);
			model.put("stock", stock);
			model.put("descripcion", descripcion);
			return "cargaEspirituosa";
		}
		return "redirect:/home";
	}
	
	
	//ENDPOINTS GET AND POST PARA MODIFICAR PRODUCTOS
	
	@GetMapping("/editarCerveza/{id}")
	public String editarCerveza(@PathVariable("id") String id, Model model) {
		
		Cerveza cerveza = cervezaServi.findById(id);
		if(cerveza != null) {
			
			model.addAttribute("id", cerveza.getId());
			model.addAttribute("categoriaC", cerveza.getCategoria());
			
		}
		return "editarProductos";
	}
	
	@GetMapping("/editarVino/{id}")
	public String editarVino(@PathVariable("id") String id, Model model) {
		
		Vino vino = vinoServi.findById(id);
		
		if (vino != null) {
			
			model.addAttribute("id", vino.getId());
			model.addAttribute("categoriaV", vino.getCategoria());
			
		}
		return "editarProductos";
	}
	
	@GetMapping("/editarEspirituosa/{id}")
	public String editarEspirituosa(@PathVariable("id") String id, Model model) {
		
		Espirituosa espirituosa = espirituosaServi.findById(id);
		if(espirituosa != null) {
			
			model.addAttribute("id", espirituosa.getId());
			model.addAttribute("categoriaE", espirituosa.getCategoria());
		}
		return "editarProductos";
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@PostMapping("/actualizar/{id}")
	public String updateProducto(ModelMap model,@PathVariable("id") String id, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio,@RequestParam(required = false) Integer stock,@RequestParam(required = false) String descripcion, String envase, String tipo, String origen, @RequestParam(required = false) String varietal, @RequestParam(required = false) String bodega) {

		//GUARDADO DE IMAGEN 
		String img = null;
		if (!imagen.isEmpty()) {
			// Path directorioImg = Paths.get("src//main//resources//static//imagenes");
			String rutaAbs = "C://Producto//recursos";
			try {
				byte[] bytesImg = imagen.getBytes();
				Path rutaCmpleta = Paths.get(rutaAbs + "//" + imagen.getOriginalFilename());
				Files.write(rutaCmpleta, bytesImg);
				img = imagen.getOriginalFilename();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		//ACTUALIZACION DE PRODUCTO
		
		Producto producto = productoServi.findById(id);
		

		if (producto.getCategoria().equals("CERVEZA")) {

			try {
				cervezaServi.modificarCerveza(descripcion, envase, varietal, img, marca, origen, otrasmarca, tipo, id, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "editarProductos";
			}

		} else if (producto.getCategoria().equals("VINO")) {

			try {
				vinoServi.modificarVino(id, descripcion, envase, varietal, bodega, img, marca, origen, otrasmarca, tipo, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "editarProductos";
			}

		} else if (producto.getCategoria().equals("ESPIRITUOSA")){

			try {
				espirituosaServi.modificarEspirituosa(descripcion, envase, img, marca, origen, otrasmarca, tipo, id, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "editarProductos";
			}
		}

		return "redirect:/producto/listar";
	}

	@GetMapping("/listar")
	public String listaProductos(ModelMap model) {

		List<Espirituosa> espirituosa= espirituosaServi.consultarEspirituosas();
		model.addAttribute("espirituosas", espirituosa);
		List<Cerveza> cerveza= cervezaServi.consultarCervezas();
		model.addAttribute("cervezas", cerveza);
		List<Vino> vino= vinoServi.consultarVinos();
		model.addAttribute("vinos", vino);
		
		return "listarProductos"; 	
	}

	@GetMapping("/detalleCerveza/{id}")
	public String detalleCerveza(@PathVariable("id") String id, Model model, RedirectAttributes attribute) throws errores {

		try {
				Cerveza cerveza = cervezaServi.findById(id);
				model.addAttribute("prod", cerveza);
				model.addAttribute("titulo", "DETALLE DEL PRODUCTO CERVEZA:");
				
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "listarProductos";
		}
				
		return "detalleProductos";
	}

	@GetMapping("/detalleVino/{id}")
	public String detalleVino(@PathVariable("id") String id, Model model, RedirectAttributes attribute) throws errores {

		try {
				Vino vino = vinoServi.findById(id);
				model.addAttribute("prod", vino);
				model.addAttribute("titulo", "DETALLE DEL PRODUCTO VINO:");
				
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "listarProductos";
		}
				
		return "detalleProductos";
	}
	
	@GetMapping("/detalleEspirituosa/{id}")
	public String detalleEspirituosa(@PathVariable("id") String id, Model model, RedirectAttributes attribute) throws errores {

		try {
				Espirituosa espirituosa = espirituosaServi.findById(id);
				model.addAttribute("prod", espirituosa);
				model.addAttribute("titulo", "DETALLE DEL PRODUCTO ESPIRITUOSA:");

		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			return "listarProductos";
		}
				
		return "detalleProductos";
	}
	
	@RequestMapping("/eliminarCerveza/{id}")
	public String eliminarCerveza(ModelMap model, @PathVariable("id") String id) throws errores {
		
		cervezaServi.eliminarCerveza(id);

		return "redirect:/producto/listar";
	}
	
	@RequestMapping("/eliminarVino/{id}")
	public String eliminarVino(ModelMap model, @PathVariable("id") String id) throws errores {
		
		vinoServi.eliminarVino(id);
		
		return "redirect:/producto/listar";
	}
	
	@RequestMapping("/eliminarEspirituosa/{id}")
	public String eliminarEspirituosa(ModelMap model, @PathVariable("id") String id) throws errores {
		
		espirituosaServi.eliminarEspirituosa(id);
		
		return "redirect:/producto/listar";
	}
	
	//PARTE USER
	
	@GetMapping("/vinoEspecifico/{id}")
	public String vinoEspecifico(ModelMap model,@PathVariable("id") String id) {
		
		//MANDAR PALABRA DEL BUSCADOR A LA VISTA
		
		try {
			Vino vino = vinoServi.findById(id);
			model.addAttribute("producto", vino);
			//model.addAttribute("titulo", "DETALLE DEL PRODUCTO VINO:");
			
		} catch(Exception e) {
		
			model.addAttribute("error", e.getMessage());
		
			return "redirect:/home";
	}
		
		return "producto";	
	}
	
	@GetMapping("/cervezaEspecifico/{id}")
	public String cervezaEspecifico(ModelMap model,@PathVariable("id") String id) {
		
		//MANDAR PALABRA DEL BUSCADOR A LA VISTA
		
		try {
			Cerveza cerveza = cervezaServi.findById(id);
			model.addAttribute("producto", cerveza);
			//model.addAttribute("titulo", "DETALLE DEL PRODUCTO CERVEZA:");
			
		} catch(Exception e) {
		
			model.addAttribute("error", e.getMessage());
		
			return "redirect:/home";
	}
		
		return "producto";	
	}
	
	@GetMapping("/espirituosaEspecifico/{id}")
	public String espirituosaEspecifico(ModelMap model,@PathVariable("id") String id) {
		
		//MANDAR PALABRA DEL BUSCADOR A LA VISTA
		
		try {
			Espirituosa espirituosa = espirituosaServi.findById(id);
			model.addAttribute("producto", espirituosa);
			//model.addAttribute("titulo", "DETALLE DEL PRODUCTO ESPIRITUOSA:");
			
		} catch(Exception e) {
		
			model.addAttribute("error", e.getMessage());
		
			return "redirect:/home";
	}
		
		return "producto";	
	}
	
	@GetMapping("/filtradoVino")
	public String filtradoVino(ModelMap modal) {
	
		List<Vino> vino= vinoServi.consultarVinos();
		modal.addAttribute("productos", vino);
		
		return "filtradoCategoria";	
	}
	
	@GetMapping("/filtradoCerveza")
	public String filtradoCerveza (ModelMap modal) {
		
		List<Cerveza> cerveza= cervezaServi.consultarCervezas();
		modal.addAttribute("productos", cerveza);
		
		return "filtradoCategoria";
	}
	
	@GetMapping("/filtradoEspirituosa")
	public String filtradoEspirituosa (ModelMap modal) {
		
		List<Espirituosa> espirituosa= espirituosaServi.consultarEspirituosas();
		modal.addAttribute("productos", espirituosa);
		
		return "filtradoCategoria";
	}

}
