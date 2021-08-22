package com.es.nagarro.petclinic.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pet")
@Getter
@Setter
public class Pet extends BaseEntity{

    @Column(name= "pet_name")
    private String name;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "bith_date")
    private LocalDate birthDate;

    @JoinColumn(name = "pet_type_id")
    @ManyToOne
    private PetType petType;

    @Column(name = "visits")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();


}
