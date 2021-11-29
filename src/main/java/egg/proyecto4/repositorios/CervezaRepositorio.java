package egg.proyecto4.repositorios;

import egg.proyecto4.entidades.Cerveza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CervezaRepositorio extends JpaRepository<Cerveza, String> {

    @Query("SELECT f FROM Cerveza f WHERE f.familia = :familia")
    public Cerveza findByFamilia(@Param("familia") String familia);
}
