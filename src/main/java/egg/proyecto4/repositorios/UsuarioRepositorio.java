package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface UsuarioRepositorio extends JpaRepository <Usuario ,String> {

 @Query("SELECT e FROM Usuario e WHERE e.email = :email")
public Usuario findByEmail(@Param("email") String email);

 @Query("SELECT c FROM Usuario c WHERE c.celular = :celular")
public Usuario findByCelular(@Param("celular") String celular);

}
