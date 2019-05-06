package dz.unvbechar.server.lamiri_service.dao;

import java.util.List;

public interface RepositoryDao<F> {
    public F save(F fichPersonne);
    public List<F> findByDate(String date);
    public List<F> findAll(F fichPersonne);
    public F findOne (String id);
    public F update(F fichPersonne);
    public void delete(String id);
}
