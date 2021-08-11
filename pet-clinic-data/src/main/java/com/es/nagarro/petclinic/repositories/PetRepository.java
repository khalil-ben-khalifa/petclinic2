package com.es.nagarro.petclinic.repositories;

import com.es.nagarro.petclinic.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<Pet, Long> {
}
