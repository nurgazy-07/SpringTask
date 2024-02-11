package java12.dao;

import java.util.List;

public interface GenericDao<T, Id> {
    void save(T entity);
    T findById(Id id);
    List<T> getAll();
    T update (Id id, T newEntity);
    void deleteById(Id id);
}
