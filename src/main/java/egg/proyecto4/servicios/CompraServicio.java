package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Compra;
import egg.proyecto4.entidades.Envio;
import egg.proyecto4.entidades.Producto;
import egg.proyecto4.entidades.Usuario;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.CompraRepositorio;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompraServicio {

    @Autowired
    private CompraRepositorio compraRepo;
    @Autowired
    private EnvioServicio serviEnvio;
    @Autowired
    private UsuarioServicio serviUser;

    private void validar(Envio envio, String medioPago, List<Producto> producto, Usuario usuario) throws errores {

        if (envio == null){
            throw new errores("Debe completar los datos del envío");
        } else if (medioPago == null || medioPago.isEmpty()) {
            throw new errores("Debe seleccionar un medio de pago.");
        } else if (producto == null || producto.isEmpty()) {
            throw new errores("Debe seleccionar un producto.");
        } else if (usuario == null) {
            throw new errores("No se encontró el usuario.");
        }

    }

    // Guardar Compra
    @Transactional
    public void guardarCompra(String direccion, String medioPago, List<Producto> producto, String email, Float precioTotal) throws errores {
        
        Compra compra = new Compra();
        compra.setFechaCompra(new Date());
        
        serviEnvio.guardarEnvio(direccion, compra.getFechaCompra()); 
        Envio envio = serviEnvio.findByDirec(direccion);  
        
        Usuario usuario = serviUser.findByEmail(email); 
        
        validar(envio, medioPago, producto, usuario);

        
        
        compra.setEnvio(envio);
        compra.setMedioPago(medioPago);
        compra.setPrecioTotal(precioTotal);
        compra.setProducto(producto);
        compra.setUsuario(usuario);
        compraRepo.save(compra);

    }

    // Modificar Compra (no creamos método debido a que no puede efectuar cambios post compras)
}
