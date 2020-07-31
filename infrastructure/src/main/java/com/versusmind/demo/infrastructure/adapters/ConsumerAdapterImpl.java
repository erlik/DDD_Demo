package com.versusmind.demo.infrastructure.adapters;

import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import com.versusmind.demo.infrastructure.dao.entities.ConsumerEntity;
import com.versusmind.demo.infrastructure.dao.repositories.ConsumerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerAdapterImpl
        extends AbstractAdapter<ConsumerValueObject, ConsumerEntity, ConsumerJpaRepository>
        implements ConsumerAdapter {

    @Autowired
    public ConsumerAdapterImpl(ConsumerJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}
