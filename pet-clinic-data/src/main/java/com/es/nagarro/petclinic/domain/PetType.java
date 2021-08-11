package com.es.nagarro.petclinic.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(name = "petTypes")
public class PetType extends BaseEntity{

    @Column(name = "pet_type_desc")
    private String name;
}
