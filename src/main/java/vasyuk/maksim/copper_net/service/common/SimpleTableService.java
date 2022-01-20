package vasyuk.maksim.copper_net.service.common;

import java.util.List;

public interface SimpleTableService<T> {
    
    List<T> getAll();
    
    void add(T item);

}
