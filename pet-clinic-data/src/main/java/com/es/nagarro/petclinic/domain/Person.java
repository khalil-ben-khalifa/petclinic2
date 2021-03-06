package com.es.nagarro.petclinic.domain;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@MappedSuperclass
public class Person extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
}
