package com.es.nagarro.petclinic.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Setter
@Getter
@Table(name = "specialities")
public class Speciality extends BaseEntity {
    @Column(name = "spec_dec")
    private String decription;
}
