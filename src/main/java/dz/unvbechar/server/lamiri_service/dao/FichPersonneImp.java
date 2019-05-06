package dz.unvbechar.server.lamiri_service.dao;

import dz.unvbechar.server.lamiri_service.entity.FichPersonne;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
@Repository
@Transactional
public class FichPersonneImp implements RepositoryDao<FichPersonne> {
    @PersistenceContext
    private EntityManager em;
    @Override
    public FichPersonne save(FichPersonne fichPersonne) {
        em.persist(fichPersonne);
        return fichPersonne;
    }

  
    @Override
    public List<FichPersonne> findAll(FichPersonne fichPersonne) {
        Query q = em.createQuery("select f from  FichPersonne f");
        em.close();
        return q.getResultList();
    }

    @Override
    public FichPersonne findOne(String id) {
        FichPersonne fichPersonne = em.find(FichPersonne.class,id);
        return fichPersonne;
    }

    @Override
    public List<FichPersonne> findByDate(String date) {
        Query q = em.createQuery("select f from  FichPersonne f where f.first_name like  :x");
        q.setParameter("x",date);
        return q.getResultList();
    }

    @Override
    public FichPersonne update(FichPersonne fichPersonne ) {
        em.merge(fichPersonne);
        return fichPersonne;
    }

    @Override
    public void delete(String id) {
        FichPersonne f = em.find(FichPersonne.class,id);

        em.remove(f);
    }
}
