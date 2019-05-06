package dz.unvbechar.server.lamiri_service.repositories;

import dz.unvbechar.server.lamiri_service.entity.FichPersonne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FichRepository extends JpaRepository<FichPersonne,Integer> {
    @Query("select f from  FichPersonne f where f.id like  :x")
    public List<FichPersonne> findAllByDate(@Param("x") int id);
}
