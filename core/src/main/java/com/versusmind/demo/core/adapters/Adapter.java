package com.versusmind.demo.core.adapters;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface Adapter<T> {
    T getById(UUID id) throws Exception;

    List<T> findAll();

    Page<T> findAll(Pageable p);

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
