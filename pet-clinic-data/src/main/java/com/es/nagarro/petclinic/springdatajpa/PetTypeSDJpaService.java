package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.PetType;
import com.es.nagarro.petclinic.repositories.PetTypePrepository;
import com.es.nagarro.petclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private PetTypePrepository petTypePrepository;
    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypePrepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypePrepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypePrepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypePrepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypePrepository.delete(object);
    }
}
