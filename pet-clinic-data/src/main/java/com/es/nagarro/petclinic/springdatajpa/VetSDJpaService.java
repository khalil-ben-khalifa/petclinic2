package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.Vet;
import com.es.nagarro.petclinic.repositories.VetsRepository;
import com.es.nagarro.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class VetSDJpaService implements VetService {
    private VetsRepository vetsRepository;

    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();
        vetsRepository.findAll().forEach(vets::add);
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetsRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetsRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetsRepository.deleteById(aLong);
    }

    @Override
    public void delete(Vet object) {
        vetsRepository.delete(object);
    }
}
