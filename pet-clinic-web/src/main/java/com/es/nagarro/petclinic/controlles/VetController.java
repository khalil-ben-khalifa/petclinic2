package com.es.nagarro.petclinic.controlles;


import com.es.nagarro.petclinic.domain.Vet;
import com.es.nagarro.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/vet")
public class VetController {
    private final VetService vetService;

    @RequestMapping("/allVets")
    public Set<Vet> vetListe(){
        Set<Vet> vets = new HashSet<>();
        vets = vetService.findAll();
        return vets;
    }


}
