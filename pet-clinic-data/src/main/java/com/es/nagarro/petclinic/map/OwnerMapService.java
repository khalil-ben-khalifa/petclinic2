package com.es.nagarro.petclinic.map;

import com.es.nagarro.petclinic.domain.Owner;
import com.es.nagarro.petclinic.domain.Pet;
import com.es.nagarro.petclinic.services.OwnerService;
import com.es.nagarro.petclinic.services.PetService;
import com.es.nagarro.petclinic.services.PetTypeService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Profile({"default", "map"})
@AllArgsConstructor
public class OwnerMapService extends AbstarctMapService<Owner, Long> implements OwnerService {

    private PetTypeService petTypeService;
    private PetService petService;
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        if(object != null){
            if(object.getPets() != null){
                object.getPets().forEach(pet -> {
                    if(pet.getPetType() != null){
                        if(pet.getPetType().getId() ==null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }

                    }else{
                        throw new RuntimeException("Pet Type is required");
                    }
                    if(pet.getId()==null){
                       Pet savedPet =  petService.save(pet);
                       pet.setId(savedPet.getId());
                    }
                });

            }

        }else{
            return null;
        }
        return object;
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner findByLastName(String lastname) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastname))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Owner> findAllByLastNameLike(String lastName) {

        // todo - impl
        return null;
    }

}
