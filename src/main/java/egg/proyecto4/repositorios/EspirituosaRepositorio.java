
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Espirituosa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspirituosaRepositorio extends JpaRepository <Espirituosa ,String>  {

}
