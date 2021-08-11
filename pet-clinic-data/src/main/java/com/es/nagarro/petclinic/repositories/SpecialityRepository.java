package com.es.nagarro.petclinic.repositories;

import com.es.nagarro.petclinic.domain.Speciality;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends CrudRepository<Speciality, Long> {
}
