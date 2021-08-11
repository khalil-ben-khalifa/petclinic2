package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.Pet;
import com.es.nagarro.petclinic.repositories.PetRepository;
import com.es.nagarro.petclinic.services.PetService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springdatajpa")
@AllArgsConstructor
@Getter
@Setter
public class PetSDJpaService implements PetService {

    public PetRepository petRepository;
    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();
        petRepository.findAll().forEach(pets::add);
        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {

        return petRepository.save(object);
    }

    @Override
    public void deleteById(Long id) {
        petRepository.findById(id);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }
}
