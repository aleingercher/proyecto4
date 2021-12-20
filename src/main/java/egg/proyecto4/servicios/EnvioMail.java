package egg.proyecto4.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import egg.proyecto4.errores.errores;

@Service
public class EnvioMail {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private UsuarioServicio serviUsuario;
	
	public void sendEmail(String toEmail, String subject, String body) {
			
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("matiicastagno007@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		
		mailSender.send(message);
	}
	
	
	public void sendEmaill(String email) {

			sendEmail(email, "Registro a Barra Libre", "Usted se ha registrado exitosamente a Barra Libre!");
	}
	
	
	public void sendEmailClave(String email) throws errores {

		Integer codigo = (int) (Math.random() * 9999 + 1111);
		serviUsuario.ModificarCodigo(email, codigo);
		sendEmail(email, "Recuperacion de clave", "ingrese el siguiente codigo para recuperar su clave: " + codigo);
		
	}
}	
