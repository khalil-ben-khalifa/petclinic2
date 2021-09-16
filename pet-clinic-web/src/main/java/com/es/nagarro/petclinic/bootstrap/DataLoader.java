package com.es.nagarro.petclinic.bootstrap;

import com.es.nagarro.petclinic.domain.*;
import com.es.nagarro.petclinic.services.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
@Slf4j
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final PetService petService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Override
    public void run(String... args) throws Exception {

        loadData();


    }

    private void loadData() {

        log.debug("---Load Pets---");
        PetType dogs = new PetType();
        dogs.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dogs);

        PetType cats = new PetType();
        cats.setName("Cat");
        PetType savedcatPetType = petTypeService.save(cats);

        log.debug("---load Speciality---");

        Speciality radiology = new Speciality();
        radiology.setDecription("radiology");
        specialityService.save(radiology);

        Speciality surgeon = new Speciality();
        surgeon.setDecription("surgeon");
        specialityService.save(surgeon);

        Speciality dentist = new Speciality();
        dentist.setDecription("dentist");
        specialityService.save(dentist);

        log.debug("---Load Owners---");
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAdress("berliner str. 32");
        owner1.setTelephon("12345");
        owner1.setCity("Berlin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Khalil");
        owner2.setLastName("Ben Khalifa");
        owner2.setAdress("potsdamer str. 63");
        owner2.setTelephon("12378");
        owner2.setCity("Berlin");

        ownerService.save(owner2);

        log.debug("---Load Pets---");
        Pet bobdog = new Pet();
        bobdog.setPetType(savedDogPetType);
        bobdog.setName("bob");
        bobdog.setBirthDate(LocalDate.now());
        bobdog.setOwner(owner1);
        petService.save(bobdog);
        owner1.getPets().add(bobdog);

        Pet mistiCat = new Pet();
        mistiCat.setName("misti");
        mistiCat.setPetType(savedcatPetType);
        mistiCat.setBirthDate(LocalDate.now());
        mistiCat.setOwner(owner2);
        petService.save(mistiCat);
        owner2.getPets().add(mistiCat);

        log.debug("---load Visits___");
        Visit mistiVisit_1 = new Visit();
        mistiVisit_1.setPet(mistiCat);
        mistiVisit_1.setDate(LocalDate.now());
        mistiVisit_1.setDescription("sneezy misti");
        visitService.save(mistiVisit_1);

        Visit bobVisit_1 = new Visit();
        bobVisit_1.setPet(bobdog);
        bobVisit_1.setDescription("brock leg bob");
        visitService.save(bobVisit_1);

        log.debug("---Load Vets---");
        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(surgeon);
        vet1.getSpecialities().add(radiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Mohamed");
        vet2.setLastName("Abobaker");
        vet2.getSpecialities().add(dentist);
        vetService.save(vet2);
    }
}
