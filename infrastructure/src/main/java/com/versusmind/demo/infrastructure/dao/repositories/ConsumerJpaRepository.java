package com.versusmind.demo.infrastructure.dao.repositories;

import com.versusmind.demo.infrastructure.dao.entities.ConsumerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ConsumerJpaRepository extends JpaRepository<ConsumerEntity, UUID> {
}
