package com.versusmind.demo.core.domain.adapters;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Adapter<T> {
    Optional<T> getById(UUID id);

    List<T> findAll();

//    Page<T> findAll(Pageable p);

    List<T> findAll(List<UUID> ids);

    void delete(UUID id);

    void delete(List<UUID> ids);

    void deleteAll();

    T update(T object);

    List<T> update(List<T> objects);

    T save(T object);

    List<T> save(List<T> objects);

    Long count();
}
