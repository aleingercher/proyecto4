package egg.proyecto4.servicios;


import egg.proyecto4.entidades.Cerveza;
import egg.proyecto4.entidades.Espirituosa;
import egg.proyecto4.entidades.Producto;
import egg.proyecto4.entidades.Vino;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServicio {

	@Autowired
	private CervezaServicio cervezaServi;
	
	@Autowired
	private VinoServicio vinoServi;
	
	@Autowired
	private EspirituosaServicio espirituosaServi;
	

	public List<Producto> findAllProductos() {
	    
		ArrayList<Producto> productos = new ArrayList<Producto>();
	     
	    List<Espirituosa> espirituosa= espirituosaServi.consultarEspirituosas();
		List<Cerveza> cerveza= cervezaServi.consultarCervezas();
		List<Vino> vino= vinoServi.consultarVinos();
		
		for (Producto c : cerveza) {
            
			productos.add(c);
        }
		
		for (Producto v : vino) {
            
			productos.add(v);
        }
		
		for (Producto e : espirituosa) {
            
			productos.add(e);
        }
		
		return productos;
	}	 
	
	 public Producto findById(String id){
		 
		 List<Producto> productos = findAllProductos();
		 Producto producto = new Producto();
		 for (Producto x: productos) {
			
			 if(id.equals(x.getId())) {
				 
				 producto = x;
			 }
		 }
		return producto;
	 }
}

