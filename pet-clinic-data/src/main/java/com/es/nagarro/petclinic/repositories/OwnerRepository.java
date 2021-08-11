package com.es.nagarro.petclinic.repositories;

import com.es.nagarro.petclinic.domain.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findOwnerByLastName (String ownerLastname);
}
