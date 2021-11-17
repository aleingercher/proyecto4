package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Cerveza;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CervezaServicio {
    
   /* @Autowired
    private CervezaRepositorio cervezaRepo; // Instanciar a repo cuando esté creado */
    
    // comentario para poder pushearr :P

    //Crear Cerveza (sin validación)
    public void guardarCerveza (Enum nombre){
        Cerveza cerveza = new Cerveza();
     //   cerveza.setFamilia(nombre);
     //  cervezaRepo.save(cerveza);
    }
    
    //Consultar Cervezas (sin validación)
 //   public List<Cerveza> consultarCervezas(){
        
     //   return cervezaRepo.findAll();
 //   }
    
    //Modificar Cerveza (sin validación)
    public void modificarCerveza (String id, String nombre){
      //  Cerveza Cerveza = cervezaRepo.findById(id).get();
        
    }
    
    //Eliminar Cerveza (sin validación)
    public void eliminarCerveza (String id){
     //   Cerveza cerveza = cervezaRepo.findById(id).get();
        
    }
}
