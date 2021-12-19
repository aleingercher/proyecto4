package egg.proyecto4.servicios;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import egg.proyecto4.entidades.Usuario;
import egg.proyecto4.enums.Role_e;
import egg.proyecto4.errores.errores;
import egg.proyecto4.repositorios.UsuarioRepositorio;
import org.springframework.security.core.userdetails.UserDetailsService;

@Service
public class UsuarioServicio implements UserDetailsService {
    

	@Autowired
    private UsuarioRepositorio usuarioRepo; 
	
	@Autowired
	private EnvioMail senderService;
	
		private void validar(String nombre,String apellido, String email, String domicilio, String localidad, String celular, String clave, String clave2) throws errores {
		
		if(nombre == null || nombre.isEmpty()) {
			throw new errores("El nommbre del usuario no puede ser nulo.");
		}else if(findByEmail(email) != null) {
			throw new errores("No se puede registrar a un cliente con un email que ya exite");
		} else if(apellido == null || apellido.isEmpty()) {
			throw new errores("El apellido del usuario no puede ser nulo.");
		}else if(domicilio == null || domicilio.isEmpty()) {
			throw new errores("El domicilio del usuario no puede ser nulo.");
		}else if(findByCelular(celular) != null ) {
			throw new errores("El celular del usuario ya existe, pruebe con otro.");
		}else if(localidad == null || localidad.isEmpty()) {
			throw new errores("La localidad del usuario no puede ser nulo.");
		}else if(celular == null || celular.isEmpty() || celular.length() < 8) {
			throw new errores("El numero de telefono del cliente no puede ser nulo y debe tener al menos 8 digitos.");
		}else if(email == null || email.isEmpty()) {
			throw new errores("El mail del cliente no puede ser nulo.");
		} else if(clave == null || clave.isEmpty() || clave.length() < 6) {
			throw new errores("La clave del cliente no puede ser nulo y debe contener mas de 6 caracteres.");
		}else if(!clave.equals(clave2)){
			throw new errores("Las claves deben ser iguales");
		}
		
		
		Pattern p1 = Pattern.compile("^[a-zA-Z]+$");										//Patron para inputs de solo caracteres. EJ:Nombre, apellido.
		Pattern p2 = Pattern.compile("^[0-9]+$");											//Patron para inputs de solo numeros. EJ: documento, telefono, nroTarjeta.
		Pattern p3 = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9-]+[.][A-Za-z]{2,}$");	//Patron para inputs que reciban solamente MAILS.
		Pattern p4 = Pattern.compile("^[A-Za-z0-9 ]+$");								//Patron para inputs para que reciba caracteres y nmros con la condicion de que el 1er caracter sea en MAY y letra.
		Pattern p5 = Pattern.compile("^[A-Za-z0-9 ]+[ ]{1}[0-9]+$");
		Pattern p6 = Pattern.compile("^[A-Za-z0-9]+$");
		
		
		Matcher mNombre = p1.matcher(nombre);
		Matcher mApellido = p1.matcher(apellido);
		Matcher mDomicilio = p5.matcher(domicilio);
		Matcher mLocalidad = p4.matcher(localidad);
		Matcher mCelular = p2.matcher(celular);
		Matcher mEmail = p3.matcher(email);
		Matcher mClave = p6.matcher(clave);
		
		if(!mNombre.find()) {
			throw new errores("Ingrese solo valores alfabeticos en (Nombre)");
		} else if (!mApellido.find()) {
			throw new errores("Ingrese solo valores alfabeticos en (Apellido)");	
		} else if (!mDomicilio.find()) {
			throw new errores("Ingrese los valores correctos en (Domicilio)");
		} else if (!mLocalidad.find()) {
			throw new errores("Ingrese los valores correctos en (Localidad)");
		} else if (!mCelular.find()) {
			throw new errores("Ingrese solo valores numericos en (Telefono)");
		} else if (!mEmail.find()) {
			throw new errores("Ingrese los valores correctos en (Mail)");
		} else if (!mClave.find()) {
			throw new errores("Ingrese solo valores entre (A-Z, a-z, 0-9) en (clave)");
		} 
		
	}
		
	@Transactional
	public void RegistrarUsuario(String nombre,String apellido, String email, String domicilio,String detalleDomicilio, String localidad,Date nacimiento, String celular, String clave, String clave2) throws errores{
		
		validar(nombre, apellido, email, domicilio, localidad, celular, clave, clave2);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Usuario usuario = new Usuario();
		
		usuario.setNombre(nombre);
		usuario.setApellido(apellido);
		usuario.setEmail(email);
		usuario.setDomicilio(domicilio);
		usuario.setDetalleDomicilio(detalleDomicilio);
		usuario.setLocalidad(localidad);
		usuario.setNacimineto(nacimiento);
		usuario.setCelular(celular);
		usuario.setClave(encoder.encode(clave));
		usuario.setRole(Role_e.USER.toString());
		
		usuarioRepo.save(usuario);
		
		senderService.sendEmaill(email);
	}
	
		public void ModificarUsuario(String id,String nombre,String apellido, String email, String domicilio,String detalleDomicilio, String localidad, String celular, String clave, String clave2) throws errores {
		
		validar(nombre, apellido, email, domicilio, localidad, celular, clave, clave2);
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		Optional<Usuario> rta = usuarioRepo.findById(id);
		
		if(rta.isPresent()) {
			
			Usuario usuario = rta.get();
			
			usuario.setNombre(nombre);
			usuario.setApellido(apellido);
			usuario.setEmail(email);
			usuario.setDomicilio(domicilio);
			usuario.setDetalleDomicilio(detalleDomicilio);
			usuario.setLocalidad(localidad);
			usuario.setCelular(celular);
			usuario.setClave(encoder.encode(clave));
			
			usuarioRepo.save(usuario);
		}else{
			throw new errores("No se encuentra el cliente solicitado");
	
		}
	}
		
	public Usuario findByEmail(String email) {
		return usuarioRepo.findByEmail(email);
	}
	
	public Usuario findByCelular(String celular) {
		return usuarioRepo.findByCelular(celular);
	}
    
        public Usuario findById(String id){
            return usuarioRepo.getById(id);
        }
        
	
	@Override
	public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
		try {
			Usuario usuario = findByEmail(email);
			User user;
			
			List<GrantedAuthority> authorities = new ArrayList<>();
			
			authorities.add(new SimpleGrantedAuthority("ROLE_"+usuario.getRole()));
			
			return new User(email, usuario.getClave(), authorities);
		}catch(Exception e) {
			throw new UsernameNotFoundException("El usuario no existe");
		}
			
		
	}
        
    
}
