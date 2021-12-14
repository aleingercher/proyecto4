package egg.proyecto4.servicios;


import egg.proyecto4.entidades.Producto;
import egg.proyecto4.repositorios.ProductoRepositorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

	@Autowired
	private ProductoRepositorio productoRepositorio;
	
	 public List<Producto> consultarProductos() {
	        return productoRepositorio.findAll();
	    }
	 
	 public Producto findById(String id) {
		 
		 return productoRepositorio.findById(id).get();
	 }

	 public void eliminar(Producto producto) {
	        productoRepositorio.delete(producto);
	 }
	 
	 public List<Producto> findByCategoria(String categoria) {
		 
		 return productoRepositorio.findByCategoria(categoria);
	 }
}
