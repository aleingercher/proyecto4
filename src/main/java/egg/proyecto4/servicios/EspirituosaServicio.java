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

    private void validar(String envase, String marca, String origen, String tipo, Float precio, Integer stock) throws errores {

        if (envase == null || envase.isEmpty()) {
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

    }

    //Guardar Espirituosa
    @Transactional
    public void guardarEspirituosa(String descripcion, String envase, String foto, String marca, String origen, String otrasMarcas, String tipo, Float precio, Integer stock) throws errores {

        validar(envase, marca, origen, tipo, precio, stock);

        Espirituosa espirituosa = new Espirituosa();

        espirituosa.setCategoria("Espirituosa");
        espirituosa.setDescripcion(descripcion);
        espirituosa.setEnvase(prettify(envase));
        espirituosa.setFoto(foto);
        espirituosa.setMarca(prettify(marca));
        espirituosa.setOrigen(prettify(origen));
        espirituosa.setOtrasMarcas(otrasMarcas);
        espirituosa.setTipo(prettify(tipo));
        espirituosa.setVendidos(0);
        espirituosa.setPrecio(precio);
        espirituosa.setStock(stock);

        espirituosaRepo.save(espirituosa);

    }

    //Modificar Espirituosa
    @Transactional
    public void modificarEspirituosa(String envase, String foto, String marca, String origen, String tipo, String id, Float precio) throws errores {

        Espirituosa espirituosa = espirituosaRepo.findById(id).get();

        espirituosa.setCategoria("Espirituosa");
        espirituosa.setEnvase(envase);
        espirituosa.setFoto(foto);
        espirituosa.setMarca(marca);
        espirituosa.setOrigen(origen);
        espirituosa.setTipo(tipo);
        espirituosa.setVendidos(0);
        espirituosa.setPrecio(precio);

        espirituosaRepo.save(espirituosa);

    }

    //Consultar Espirituosa
    public List<Espirituosa> consultarEspirituosas() {
        return espirituosaRepo.findAll();
    }

    public Espirituosa findById(String id) {
        return espirituosaRepo.getById(id);
    }

    public void eliminarEspirituosa(String id) {
        Espirituosa espirituosa = espirituosaRepo.findById(id).get();
        espirituosaRepo.delete(espirituosa);
    }

    public String prettify(String en) {
        String pretty = en.replace("_", " ").toLowerCase();
        pretty = pretty.substring(0, 1).toUpperCase() + pretty.substring(1);
        return pretty;
    }
}
