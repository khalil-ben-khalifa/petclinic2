package com.es.nagarro.petclinic.springdatajpa;

import com.es.nagarro.petclinic.domain.Owner;
import com.es.nagarro.petclinic.repositories.OwnerRepository;
import com.es.nagarro.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {
    private OwnerRepository ownerRepository;

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findOwnerByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners::add);
        return owners;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        System.out.println("########################");
        System.out.println("########################");
        System.out.println("########################");
        return ownerRepository.save(object);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {
        return null;
    }


}
