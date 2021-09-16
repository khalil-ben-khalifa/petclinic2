package com.es.nagarro.petclinic.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "petTypes")
public class PetType extends BaseEntity{
    @Builder
    public PetType(Long id, String name) {
        super(id);
        this.name = name;
    }
    @Column(name = "pet_type_desc")
    private String name;

    @Override
    public String toString() {
        return name;
    }
}
