package com.es.nagarro.petclinic.controlles;


import com.es.nagarro.petclinic.domain.Owner;
import com.es.nagarro.petclinic.services.OwnerService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RequestMapping("/owners")
@RestController
@AllArgsConstructor
public class OwnerController {
    private final OwnerService ownerService;

    @RequestMapping("/listOwners")
    public Set<Owner> listOwners(Model model){
        Set<Owner> owners = new HashSet<>();
        owners = ownerService.findAll();
        return owners;

    }
}
