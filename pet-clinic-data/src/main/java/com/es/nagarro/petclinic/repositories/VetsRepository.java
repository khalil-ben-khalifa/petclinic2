package com.es.nagarro.petclinic.repositories;

import com.es.nagarro.petclinic.domain.Vet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetsRepository extends CrudRepository<Vet, Long> {
}
