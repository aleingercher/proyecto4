package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Cerveza;
import egg.proyecto4.entidades.Foto;
import egg.proyecto4.enums.Categoria_e;
import egg.proyecto4.errores.errores;
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

    private void validar(String descripcion, String envase, String familia, String marca, String origen, String tipo) throws errores {

        if (descripcion == null || descripcion.isEmpty()) {
            throw new errores("La descripción no puede estar vacía.");
        } else if (envase == null || envase.isEmpty()) {
            throw new errores("Debe seleccionar un envase para la cerveza.");
        } else if (familia == null || familia.isEmpty()) {
            throw new errores("Debe seleccionar un tipo de familia.");
        } else if (marca == null || marca.isEmpty()) {
            throw new errores("Debe seleccionar una marca.");
        } else if (origen == null || origen.isEmpty()) {
            throw new errores("Debe seleciconar un origen.");
        } else if (tipo == null || tipo.isEmpty()) {
            throw new errores("Debe seleccionar un tipo.");
        }

        Pattern p1 = Pattern.compile("^[a-zA-Z0-9]+$");

        Matcher mDescripcion = p1.matcher(descripcion);

        if (!mDescripcion.find()) {
            throw new errores("Ingrese solo caracteres y valores númericos");
        }

    }

    //Guardar Cerveza 
    @Transactional
    public void guardarCerveza(String descripcion, String envase, String familia, Foto foto, String marca, String origen, String otrasMarcas, String tipo) throws errores {

        validar(descripcion, envase, familia, marca, origen, tipo);

        Cerveza cerveza = new Cerveza();
        cerveza.setCategoria(Categoria_e.CERVEZA);
        cerveza.setDescripcion(descripcion);
        cerveza.setEnvase(envase);
        cerveza.setFamilia(familia);
        cerveza.setFoto(foto);  //Ver esto
        cerveza.setMarca(marca);
        cerveza.setOrigen(origen);
        cerveza.setOtrasMarcas(otrasMarcas);
        cerveza.setPrecio(Float.NaN);
        cerveza.setStock(Integer.SIZE);
        cerveza.setTipo(tipo);
        cerveza.setVendidos(Integer.SIZE);
        cervezaRepositorio.save(cerveza);

    }

    //Modificar Cerveza
    @Transactional
    public void modificarCerveza(String descripcion, String envase, String familia, Foto foto, String marca, String origen, String otrasMarcas, String tipo, String id) throws errores {

        validar(descripcion, envase, familia, marca, origen, tipo);

        Cerveza cerveza = cervezaRepo.findById(id).get();
    }

    //Consultar Cervezas (sin validación)
    public List<Cerveza> consultarCervezas() {
        return cervezaRepo.findAll();
    }

    //Eliminar Cerveza (sin validación)
    public void eliminarCerveza(String id) {
        Cerveza cerveza = cervezaRepo.findById(id).get();

    }
}
