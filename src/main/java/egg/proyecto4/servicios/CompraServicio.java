package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Compra;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.CompraRepositorio;
import java.util.Date;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicio {

    @Autowired
    private CompraRepositorio compraRepo;

    private void validar(String envio, String medioPago, String producto, String usuario) throws errores {

        if (envio == null || envio.isEmpty()) {
            throw new errores("Debe completar los datos del envío"); // Descripción ok?
        } else if (medioPago == null || medioPago.isEmpty()) {
            throw new errores("Debe seleccionar un medio de pago.");
        } else if (producto == null || producto.isEmpty()) {
            throw new errores("Debe seleccionar un producto");
        } else if (usuario == null || usuario.isEmpty()) {
            throw new errores("Debe seleccionar su usuario."); // ver esto
        }

        //Siendo que son enums, no es necesario pattern y match (revisar).
    }

    // Guardar Compra
    @Transactional
    public void guardarCompra(String envio, Date fechaCompra, String medioPago, String producto, String usuario) throws errores {

        validar(envio, medioPago, producto, usuario);

        Compra compra = new Compra();
        compra.setEnvio(envio);
        compra.setFechaCompra(fechaCompra);
        compra.setMedioPago(medioPago);
        compra.setPrecioTotal(Float.MIN_NORMAL); //ver si va así, o se pasa por parametro
        compra.setProducto(producto);
        compra.setUsuario(usuario);
        compraRepositorio.save(compra);

    }

    // Modificar Compra
    @Transactional
    public void modificarCompra(String envio, Date fechaCompra, String medioPago, String producto, String usuario, String id) throws errores{
        
        validar(envio, medioPago, producto, usuario);
        
        Compra compra = compraRepo.findById(id).get();
    }
    
    
}
