package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.Visit;
import com.es.nagarro.petclinic.repositories.VisitsRepository;
import com.es.nagarro.petclinic.services.VisitService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class VisitSDJpaService implements VisitService {
    public VisitsRepository visitsRepository;
    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitsRepository.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitsRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitsRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitsRepository.deleteById(aLong);
    }

    @Override
    public void delete(Visit object) {
        visitsRepository.delete(object);
    }
}
