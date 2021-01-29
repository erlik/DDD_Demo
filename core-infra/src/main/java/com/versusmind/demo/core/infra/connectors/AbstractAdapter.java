package com.versusmind.demo.core.infra.connectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public abstract class AbstractAdapter<M, S, J extends JpaRepository<S, UUID>> {

    protected J jpaRepository;

    private Class<M> valueObjectClass = (Class<M>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    private Class<S> persistentClass = (Class<S>) ((ParameterizedType) getClass()
            .getGenericSuperclass()).getActualTypeArguments()[0];

    private ModelMapper modelMapper = new ModelMapper();

    public AbstractAdapter(J jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    public Optional<M> getById(UUID id) {
        return Optional.of(mapToDTO(jpaRepository.findById(id).orElse(null)));
    }

    public List<M> findAll(List<UUID> ids) {

        return mapToDTO(jpaRepository.findAllById(ids));
    }

    public Page<M> findAll(Pageable p) {
        return jpaRepository.findAll(p).map(this::mapToDTO);
    }

    public List<M> findAll() {
        return Optional.of(mapToDTO(jpaRepository.findAll())).orElse(Collections.emptyList());
    }

    public M update(M update) {
        return mapToDTO(jpaRepository.save(mapToEntity(update)));
    }

    public List<M> update(List<M> list) {
        return mapToDTO(jpaRepository.saveAll(mapToEntity(list)));
    }

    public M save(M save) {
        return mapToDTO(jpaRepository.save(mapToEntity(save)));
    }

    public List<M> save(List<M> list) {
        return mapToDTO(jpaRepository.saveAll(mapToEntity(list)));
    }

    public void delete(UUID id) {
        jpaRepository.deleteById(id);

    }

    public void delete(List<UUID> ids) {
        List<S> list = jpaRepository.findAllById(ids);
        jpaRepository.deleteAll(list);
    }

    public void deleteAll() {
        jpaRepository.deleteAll();
    }

    public Long count() {
        return jpaRepository.count();
    }

    private M mapToDTO(S s) {
        return modelMapper.map(s, valueObjectClass);
    }

    private List<M> mapToDTO(List<S> s) {
        return s.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private S mapToEntity(M s) {
        return modelMapper.map(s, persistentClass);
    }

    private List<S> mapToEntity(List<M> s) {
        return s.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }
}
