package com.versusmind.demo.infrastructure.adapters;

import com.versusmind.demo.core.infra.connectors.AbstractAdapter;
import com.versusmind.demo.domain.ConsumerValueObject;
import com.versusmind.demo.domain.adapters.ConsumerAdapter;
import com.versusmind.demo.infrastructure.dao.entities.ConsumerEntity;
import com.versusmind.demo.infrastructure.dao.repositories.ConsumerJpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsumerAdapterImpl
        extends AbstractAdapter<ConsumerValueObject, ConsumerEntity, ConsumerJpaRepository>
        implements ConsumerAdapter {

    public ConsumerAdapterImpl(ConsumerJpaRepository jpaRepository) {
        super(jpaRepository);
    }
}
