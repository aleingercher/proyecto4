package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Cerveza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CervezaServicio {
    
   /* @Autowired
    private CervezaRepositorio cervezaRepo; // Instanciar a repo cuando esté creado */
    
    

    //Crear Cerveza (sin validación)
    public void guardarCerveza (String nombre){
        Cerveza cerveza = new Cerveza();
        
    }
}
