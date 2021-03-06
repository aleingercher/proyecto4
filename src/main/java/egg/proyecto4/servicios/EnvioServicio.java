package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Envio;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.EnvioRepositorio;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnvioServicio {

    @Autowired
    private EnvioRepositorio envioRepo;

    private void validar(String direccion) throws errores {

        if (direccion == null || direccion.isEmpty()) {
            throw new errores("Debe completar con su direccion.");
        }

        Pattern p5 = Pattern.compile("^[a-z][0-9]+[ ]{1}[0-9]+$");

        Matcher mDireccion = p5.matcher(direccion);

        if (!mDireccion.find()) {
            throw new errores("Ingrese solo caracteres y valores númericos");
        }
    }

    // Guardar Envío
    @Transactional
    public void guardarEnvio(String direccion, Date fecha) throws errores {

        validar(direccion);

        long aux = fecha.getTime() + 2700000;

        Envio envio = new Envio();
        envio.setDireccion(direccion);
        envio.setFecha(new Date(aux));
        envioRepo.save(envio);

    }

    // Modificar Envío
    @Transactional
    public void modificarEnvio(String direccion, String id) throws errores {

        validar(direccion);

        Envio envio = envioRepo.findById(id).get();
        envio.setDireccion(direccion);

    }
    
   public Envio findByDirec(String direccion){
        return envioRepo.findByDirec(direccion);
      }

}
