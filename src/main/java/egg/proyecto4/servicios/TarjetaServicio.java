package egg.proyecto4.servicios;

import egg.proyecto4.entidades.Tarjeta;
import egg.proyecto4.entidades.Usuario;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.TarjetaRepositorio;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarjetaServicio {

    @Autowired
    private TarjetaRepositorio tarjetaRepo;
    @Autowired
    private UsuarioServicio serviUser;

    private void validar(String nroTarjeta, String vencimiento, String titular, String ccv, Usuario usuario) throws errores {
        if (nroTarjeta == null || nroTarjeta.isEmpty()) {
            throw new errores("Debe completar con los números de su tarjeta.");
        } else if (vencimiento == null || vencimiento.isEmpty()) {
            throw new errores("Debe completar con la fecha de vencimiento de su tarjeta");
        } else if (titular == null || titular.isEmpty()) {
            throw new errores("Debe completar con el nombre del titular de la tarjeta");
        } else if (ccv == null || ccv.isEmpty()) {
            throw new errores("Debe completar con el código de seguridad del dorso de su tarjeta");
        } else if (usuario == null) {
            throw new errores("No se encontró el usuario.");
        } 
        
        Pattern p1 = Pattern.compile("^[a-zA-Z]+$");
        Pattern p2 = Pattern.compile("^[0-9]+$");
        
        Matcher mNroTarjeta = p2.matcher(nroTarjeta);
        Matcher mVencimiento = p2.matcher(vencimiento);
        Matcher mTitular = p1.matcher(titular);
        Matcher mCcv = p2.matcher(ccv);
        
        if (!mNroTarjeta.find()) {
            throw new errores("Ingrese solo valores númericos");
        } else if (!mVencimiento.find()){
            throw new errores("Ingrese solo valores númericos");
        } else if (!mTitular.find()){
            throw new errores("Ingrese solo caracteres");
        } else if (!mCcv.find()){
            throw new errores("ingrese solo valores númericos");
        }
        
    }
    
    //Guardar Tarjeta
    @Transactional
    public void guardarTarjeta(String nroTarjeta, String vencimiento, String titular, String ccv, String email) throws errores {

        Tarjeta tarjeta = new Tarjeta();
        Usuario usuario = serviUser.findByEmail(email);

        validar(nroTarjeta,vencimiento,titular,ccv,usuario);
        
        tarjeta.setNroTarjeta(nroTarjeta);
        tarjeta.setVencimiento(vencimiento);
        tarjeta.setTitular(titular);
        tarjeta.setCcv(ccv);
        tarjeta.setUsuario(usuario);
        tarjetaRepo.save(tarjeta);

    }

    
    // Modificar Compra
    @Transactional
    public void modificarCompra (String nroTarjeta, String vencimiento, String titular, String ccv, String email, String id) throws errores {
        
        Usuario usuario = serviUser.findByEmail(email);
        
        validar(nroTarjeta,vencimiento,titular,ccv,usuario);
        
        Tarjeta tarjeta = tarjetaRepo.findById(id).get();
        tarjeta.setNroTarjeta(nroTarjeta);
        tarjeta.setTitular(titular);
        tarjeta.setVencimiento(vencimiento);
        tarjeta.setCcv(ccv);
        
    }
    
}
