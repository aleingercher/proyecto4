package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Vino;
import egg.proyecto4.enums.Categoria_e;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.VinoRepositorio;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VinoServicio {

    @Autowired
    private VinoRepositorio vinoRepo;

    private void validar(String descripcion, String envase, String varietal, String bodega, String marca, String origen, String tipo, Float precio, Integer stock) throws errores {

        if (descripcion == null || descripcion.isEmpty()) {
            throw new errores("La descripción no puede estar vacía.");
        } else if (envase == null || envase.isEmpty()) {
            throw new errores("Debe seleccionar un envase para la cerveza.");
        } else if (varietal == null || varietal.isEmpty()) {
            throw new errores("Debe seleccionar un tipo de varietal.");
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
        } else if (bodega == null || bodega.isEmpty()) {
            throw new errores("Debe seleccionar una bodega.");
        }

        Pattern p1 = Pattern.compile("^[a-zA-Z0-9]+$");

        Matcher mDescripcion = p1.matcher(descripcion);

        if (!mDescripcion.find()) {
            throw new errores("Ingrese solo caracteres y valores númericos");
        }

    }
    
    //Guardar Vino
    @Transactional
    public void guardarVino(String descripcion, String envase, String varietal, String bodega, String foto, String marca, String origen, String otrasMarcas, String tipo, Float precio, Integer stock) throws errores {

        validar(descripcion,envase,varietal,bodega,marca,origen,tipo,precio,stock);
        
        Vino vino = new Vino();
        
        vino.setBodega(bodega);
        vino.setCategoria(Categoria_e.VINO);
        vino.setDescripcion(descripcion);
        vino.setEnvase(envase);
        vino.setFoto(foto);
        vino.setMarca(marca);
        vino.setOrigen(origen);
        vino.setOtrasMarcas(otrasMarcas);
        vino.setPrecio(precio);
        vino.setStock(stock);
        vino.setTipo(tipo);
        vino.setVendidos(0);
        vino.setPrecio(precio);
        vino.setVarietal(varietal);
        
        vinoRepo.save(vino);

    }

    
    //Modificar Vino
    @Transactional
    public void modificarVino (String id,String descripcion, String envase, String varietal, String bodega, String foto, String marca, String origen, String otrasMarcas, String tipo, Float precio, Integer stock) throws errores {
        
        validar(descripcion,envase,varietal,bodega,marca,origen,tipo,precio,stock);
        
        Vino vino = vinoRepo.findById(id).get();
        
        vino.setBodega(bodega);
        vino.setCategoria(Categoria_e.CERVEZA);
        vino.setDescripcion(descripcion);
        vino.setEnvase(envase);
        vino.setFoto(foto);
        vino.setMarca(marca);
        vino.setOrigen(origen);
        vino.setOtrasMarcas(otrasMarcas);
        vino.setPrecio(precio);
        vino.setStock(stock);
        vino.setTipo(tipo);
        vino.setVendidos(0);
        vino.setPrecio(precio);
        vino.setVarietal(varietal);
        
        vinoRepo.save(vino);
        
    }
    
    //Consultar Vino
    public List<Vino> consultarVinos(){
        return vinoRepo.findAll();
    }
    
    public Vino findById(String id){
        return vinoRepo.getById(id);
    }
    
    public void eliminarVino(String id){
        Vino vino = vinoRepo.findById(id).get();
        vinoRepo.delete(vino);
    }
}
