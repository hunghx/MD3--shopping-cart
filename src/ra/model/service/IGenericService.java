package ra.model.service;

import java.util.List;

public interface IGenericService<T> {
    List<T> findAll();
    void save(T t);
    T findById(int id);
    void delete(int id);
    List<T> searchByName(String searchName);
}
