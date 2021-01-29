package com.versusmind.demo.infrastructure.dao.entities;

import com.versusmind.demo.core.infra.dao.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class ConsumerEntity extends BaseEntity {

    private String firstname;
    private String lastname;

    @OneToOne(cascade = CascadeType.ALL)
    private AddressEntity addressEntity;
}
