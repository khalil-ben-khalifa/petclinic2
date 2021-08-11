package com.es.nagarro.petclinic.bootstrap;

import com.es.nagarro.petclinic.domain.Owner;
import com.es.nagarro.petclinic.domain.PetType;
import com.es.nagarro.petclinic.domain.Vet;
import com.es.nagarro.petclinic.map.OwnerMapService;
import com.es.nagarro.petclinic.map.PetTypeServiceMap;
import com.es.nagarro.petclinic.map.VetServiceMap;
import com.es.nagarro.petclinic.services.OwnerService;
import com.es.nagarro.petclinic.services.VetService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Khalil");
        owner2.setLastName("Ben Khalifa");

        ownerService.save(owner2);

        System.out.println("Loaded Owners ....");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mohamed");
        vet2.setLastName("Abobaker");

        vetService.save(vet2);

        System.out.println("Loaded Vet.....");

    }
}
