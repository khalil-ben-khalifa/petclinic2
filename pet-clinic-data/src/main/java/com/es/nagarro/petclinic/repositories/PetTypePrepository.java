package com.es.nagarro.petclinic.repositories;

import com.es.nagarro.petclinic.domain.PetType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetTypePrepository extends CrudRepository<PetType, Long> {
}
