package vasyuk.maksim.copper_net.service;

import java.util.List;

public interface NodeTypesService<T> {
    List<T> getAll();
    
    T getById(Long id);

    void add(T item);

}
