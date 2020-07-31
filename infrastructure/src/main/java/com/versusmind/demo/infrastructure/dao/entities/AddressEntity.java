package com.versusmind.demo.infrastructure.dao.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
public class AddressEntity extends BaseEntity {
    private String number;
    private String street;
    private String postalCode;
    private String city;
}
