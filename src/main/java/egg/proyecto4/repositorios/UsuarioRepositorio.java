package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario ,String> {

    // CONSTRUCTORES

    // GETTERS / SETTERS
}
