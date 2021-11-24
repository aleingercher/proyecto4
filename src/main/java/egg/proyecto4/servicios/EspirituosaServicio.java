package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Espirituosa;
import egg.proyecto4.enums.Categoria_e;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.EspirituosaRepositorio;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspirituosaServicio {
    
    @Autowired
    private EspirituosaRepositorio espirituosaRepo;
    
    private void validar(String descripcion, String envase, String marca, String origen, String tipo, Float precio, Integer stock) throws errores {
        
        if (descripcion == null || descripcion.isEmpty()) {
            throw new errores("La descripción no puede estar vacía.");
        } else if (envase == null || envase.isEmpty()) {
            throw new errores("Debe seleccionar un envase para la cerveza.");
        } else if (marca == null || marca.isEmpty()) {
            throw new errores("Debe seleccionar una marca.");
        } else if (origen == null || origen.isEmpty()) {
            throw new errores("Debe seleciconar un origen.");
        } else if (tipo == null || tipo.isEmpty()) {
            throw new errores("Debe seleccionar un tipo.");
        } else if (precio == null || tipo.isEmpty()) {
            throw new errores("Debe contener un precio.");
        } else if (stock == null || tipo.isEmpty()) {
            throw new errores("Debe haber stock.");
        } 

        Pattern p1 = Pattern.compile("^[a-zA-Z0-9]+$");

        Matcher mDescripcion = p1.matcher(descripcion);

        if (!mDescripcion.find()) {
            throw new errores("Ingrese solo caracteres y valores númericos");
        }
    }
    
    
    //Guardar Espirituosa
    @Transactional
    public void guardarEspirituosa (String descripcion, String envase,String foto, String marca, String origen, String otrasMarcas, String tipo, Float precio, Integer stock) throws errores {
        
        validar(descripcion,envase,marca,origen,tipo,precio,stock);
        
        Espirituosa espirituosa = new Espirituosa();
        
        espirituosa.setCategoria(Categoria_e.ESPIRITUOSAS);
        espirituosa.setDescripcion(descripcion);
        espirituosa.setEnvase(envase);
        espirituosa.setFoto(foto);
        espirituosa.setMarca(marca);
        espirituosa.setOrigen(origen);
        espirituosa.setOtrasMarcas(otrasMarcas);
        espirituosa.setTipo(tipo);
        espirituosa.setVendidos(0);
        espirituosa.setPrecio(precio);
        espirituosa.setStock(stock);
        
        espirituosaRepo.save(espirituosa);
        
    }
    
    //Modificar Espirituosa
    @Transactional
    public void modificarEspirituosa(String descripcion, String envase,String foto, String marca, String origen, String otrasMarcas, String tipo, String id, Float precio, Integer stock) throws errores {
        
        validar(descripcion,envase,marca,origen,tipo,precio,stock);
        
        Espirituosa espirituosa = espirituosaRepo.findById(id).get();
        
        espirituosa.setCategoria(Categoria_e.ESPIRITUOSAS);
        espirituosa.setDescripcion(descripcion);
        espirituosa.setEnvase(envase);
        espirituosa.setFoto(foto);
        espirituosa.setMarca(marca);
        espirituosa.setOrigen(origen);
        espirituosa.setOtrasMarcas(otrasMarcas);
        espirituosa.setTipo(tipo);
        espirituosa.setVendidos(0);
        espirituosa.setPrecio(precio);
        espirituosa.setStock(stock);
        
        espirituosaRepo.save(espirituosa);
        
    }
    
    //Consultar Espirituosa
    public List<Espirituosa> consultarEspirituosas(){
        return espirituosaRepo.findAll();
    }
    
 
}
