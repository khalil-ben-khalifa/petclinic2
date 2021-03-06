package com.es.nagarro.petclinic.services;

import com.es.nagarro.petclinic.domain.Owner;
import com.es.nagarro.petclinic.services.CrudService;

import java.util.List;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastname);
    List<Owner> findAllByLastNameLike(String lastName);
}
