package java12.service;

import java.util.List;

public interface GenericService<T, Id>{
    void save(T entity);
    T findById(Id id);
    List<T> getAll();
    T update (Id id, T newEntity);
    void deleteById(Id id);
}
