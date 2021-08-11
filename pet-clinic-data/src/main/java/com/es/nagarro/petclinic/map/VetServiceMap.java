package com.es.nagarro.petclinic.map;

import com.es.nagarro.petclinic.domain.Speciality;
import com.es.nagarro.petclinic.domain.Vet;
import com.es.nagarro.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@AllArgsConstructor
@Profile({"default", "map"})
public class VetServiceMap extends AbstarctMapService<Vet, Long> implements VetService {
    private SpecialityServiceMap specialityServiceMap;
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public Vet save(Vet object) {
        if(object.getId() !=0){
            if(object.getSpecialities().size() > 0){
                object.getSpecialities().forEach(speciality ->
                {if(speciality.getId()==null){
                    Speciality savedSpeciality = specialityServiceMap.save(speciality);
                    speciality.setId(savedSpeciality.getId());
                }
                });
            }
        }
        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
