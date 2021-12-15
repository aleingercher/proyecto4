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
	public String cerveza (ModelMap model, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock, String descripcion,String familia, String envase, String tipo, String origen) {
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
			cervezaServi.guardarCerveza(descripcion, envase, familia, img, marca, origen, otrasmarca, tipo, precio, stock);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			model.put("precio", precio);
			model.put("stock", stock);
			model.put("descripcion", descripcion);
			return "cargaCerveza";
		}
		return "home";
	}
	
	@PostMapping("/vinoSave")
	public String vino (ModelMap model, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock,          String descripcion,String bodega, String varietal, String envase, String tipo, String origen) {
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
			vinoServi.guardarVino(descripcion, envase, varietal, bodega, img, marca, origen, otrasmarca, tipo, precio, stock);
		} catch (Exception e) {
			model.put("error", e.getMessage());
			model.put("precio", precio);
			model.put("stock", stock);
			model.put("descripcion", descripcion);
			return "cargaVino";
		}
		return "home";
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
		return "home";
	}
	
	
	//ENDPOINTS GET AND POST PARA MODIFICAR PRODUCTOS
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") String id, Model model) {
		
		Cerveza cerveza = cervezaServi.findById(id);
		Vino vino = vinoServi.findById(id);
		Espirituosa espirituosa = espirituosaServi.findById(id);
		if(cerveza != null) {
			
			model.addAttribute("cerveza", cerveza);
			
		} else if (vino != null) {
			
			model.addAttribute("vino", vino);
			
		} else {
			
			model.addAttribute("espirituosa", espirituosa);
		}
		return "editarProductos";
	}
	
	@PostMapping("/actualizar/{id}")
	public String updatePerso(ModelMap model,@PathVariable("id") String id, MultipartFile imagen,String marca,@RequestParam(required = false) String otrasmarca,Float precio, Integer stock, String descripcion, String envase, String tipo, String origen, @RequestParam(required = false) String familia, @RequestParam(required = false) String bodega, @RequestParam(required = false) String varietal) {

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

		Cerveza cerveza = cervezaServi.findById(id);
		Vino vino = vinoServi.findById(id);
		Espirituosa espirituosa = espirituosaServi.findById(id);

		if (cerveza != null) {

			try {
				cervezaServi.modificarCerveza(descripcion, envase, familia, img, marca, origen, otrasmarca, tipo, id, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "cervezaUpdate";
			}

		} else if (vino != null) {

			try {
				vinoServi.modificarVino(id, descripcion, envase, varietal, bodega, img, marca, origen, otrasmarca, tipo, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "vinoUpdate";
			}

		} else {

			try {
				espirituosaServi.modificarEspirituosa(descripcion, envase, img, marca, origen, otrasmarca, tipo, id, precio, stock);
			} catch (Exception e) {
				model.put("error", e.getMessage());
				model.put("descripcion", descripcion);
				model.put("precio", precio);
				model.put("stock", stock);
				return "espirituosaUpdate";
			}
		}

		return "listarProducto";
	}

	@GetMapping("/listar")
	public String listaProductos(ModelMap model) {

		List<Producto> productos = productoServi.consultarProductos();
		model.put("productos", productos);

		return "listarProductos"; 	
	}

	@GetMapping("/detalle/{id}")
	public String detalle(@PathVariable("id") String id, Model model, RedirectAttributes attribute) throws errores {

		try {
				Producto producto = productoServi.findById(id);
		
				model.addAttribute("prod", producto);
		} catch(Exception e) {
			model.addAttribute("error", e.getMessage());
			List<Producto> productos = productoServi.consultarProductos();
			model.addAttribute("productos", productos);
			return "listarProductos";
		}
				
		return "detalleProductos";
	}

	@RequestMapping("/eliminar/{id}")
	public String eliminar(ModelMap model, @PathVariable("id") String id) throws errores {

		Producto producto = productoServi.findById(id);
		
		productoServi.eliminar(producto);

		List<Producto> productos = productoServi.consultarProductos();
		model.put("productos", productos);

		return "listarProductos";
	}
	
	
	//PARTE USER
	
	@GetMapping("/productoEspecifico")
	public String productoEspecifico(ModelMap modal,String buscar) {
		
		//MANDAR PALABRA DEL BUSCADOR A LA VISTA
		
		modal.addAttribute("producto", buscar);
		
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
