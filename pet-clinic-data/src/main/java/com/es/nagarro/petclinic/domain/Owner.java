package com.es.nagarro.petclinic.domain;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "owners")
@Setter
@Getter
public class Owner extends Person{

    @Column(name = "adress")
    private String adress;
    @Column(name = "city")
    private String city;
    @Column(name = "telephon")
    private String telephon;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    @Column(name = "pets")
    private Set<Pet> pets = new HashSet<>();

}
