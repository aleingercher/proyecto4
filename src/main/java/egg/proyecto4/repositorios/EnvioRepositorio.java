
package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepositorio extends JpaRepository <Envio ,String> {
@Query("SELECT c FROM Envio c WHERE c.direccion = :direccion")
public Envio findByDirec(@Param("direccion") String direccion);

    //    @Query("SELECT a FROM Autor a WHERE a.nombre=:nombre")
    //public Autor findByNombre (@Param("nombre") String nombre); 
}
