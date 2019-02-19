package app.repository;

import java.util.List;

public interface GenericRepository<E,K> {
    List<E> findAll();

    E save (E entity);
}
