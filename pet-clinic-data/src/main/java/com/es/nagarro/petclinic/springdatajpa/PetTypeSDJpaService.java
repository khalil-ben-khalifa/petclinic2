package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.PetType;
import com.es.nagarro.petclinic.repositories.PetTypeRrepository;
import com.es.nagarro.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class PetTypeSDJpaService implements PetTypeService {
    private PetTypeRrepository petTypeRrepository;
    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRrepository.findAll().forEach(petTypes::add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRrepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRrepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRrepository.deleteById(aLong);
    }

    @Override
    public void delete(PetType object) {
        petTypeRrepository.delete(object);
    }
}
