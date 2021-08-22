package com.es.nagarro.petclinic.map;

import com.es.nagarro.petclinic.domain.Visit;
import com.es.nagarro.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
@Profile({"default", "map"})
public class VisitServiceMap extends AbstarctMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.findById(id);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit.getPet() == null || visit.getPet().getId() == null || visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Pet or Owner are required");
        } else {
            return super.save(visit);
        }
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
