package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Cerveza;
import egg.proyecto4.enums.Categoria_e;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.CervezaRepositorio;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CervezaServicio {

    @Autowired
    private CervezaRepositorio cervezaRepo;

    private void validar( String envase, String varietal, String marca, String origen, String tipo, Float precio, Integer stock) throws errores {

        if (envase == null || envase.isEmpty()) {
            throw new errores("Debe seleccionar un envase para la cerveza.");
        } else if (varietal == null || varietal.isEmpty()) {
            throw new errores("Debe seleccionar un tipo de familia.");
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

    }

    //Guardar Cerveza 
    @Transactional
    public void guardarCerveza(String descripcion, String envase, String varietal, String foto, String marca, String origen, String otrasMarcas, String tipo, Float precio, Integer stock) throws errores {

        validar(envase, varietal, marca, origen, tipo, precio, stock);

        Cerveza cerveza = new Cerveza();
        
        cerveza.setCategoria(Categoria_e.CERVEZA);
        cerveza.setDescripcion(descripcion);
        cerveza.setEnvase(envase);
        cerveza.setVarietal(varietal);
        cerveza.setFoto(foto);
        cerveza.setMarca(marca);
        cerveza.setOrigen(origen);
        cerveza.setOtrasMarcas(otrasMarcas);
        cerveza.setTipo(tipo);
        cerveza.setVendidos(0);
        cerveza.setPrecio(precio);
        cerveza.setStock(stock);
        
        cervezaRepo.save(cerveza);

    }

    //Modificar Cerveza
    @Transactional
    public void modificarCerveza(String descripcion, String envase, String varietal, String foto, String marca, String origen, String otrasMarcas, String tipo, String id, Float precio, Integer stock) throws errores {

        validar( envase, varietal, marca, origen, tipo, precio, stock);

        Cerveza cerveza = cervezaRepo.findById(id).get();
        
        cerveza.setCategoria(Categoria_e.CERVEZA);
        cerveza.setDescripcion(descripcion);
        cerveza.setEnvase(envase);
        cerveza.setVarietal(varietal);
        cerveza.setFoto(foto);
        cerveza.setMarca(marca);
        cerveza.setOrigen(origen);
        cerveza.setOtrasMarcas(otrasMarcas);
        cerveza.setTipo(tipo);
        cerveza.setVendidos(0);
        cerveza.setPrecio(precio);
        cerveza.setStock(stock);
        
        cervezaRepo.save(cerveza);
        
    }

    //Consultar Cervezas (sin validación)
    public List<Cerveza> consultarCervezas() {
        return cervezaRepo.findAll();
    }
    
    public Cerveza findById(String id){
        return cervezaRepo.getById(id);
    }

    //Eliminar Cerveza (sin validación)
    public void eliminarCerveza(String id) {
        Cerveza cerveza = cervezaRepo.findById(id).get();
        cervezaRepo.delete(cerveza);
    }
}
