package com.springframe5.hwtpetclinic.bootstrap;

import com.springframe5.hwtpetclinic.model.*;
import com.springframe5.hwtpetclinic.services.OwnerService;
import com.springframe5.hwtpetclinic.services.PetTypeService;
import com.springframe5.hwtpetclinic.services.SpecialityService;
import com.springframe5.hwtpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = specialityService.findAll().size();

        if(count == 0) loadData();
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        specialityService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");
        specialityService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("Weston");
        owner1.setAddress("Ang Mo Kio Avenue 4");
        owner1.setCity("Singapore");
        owner1.setTelephone("0000000");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Rosco");
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);


        Owner owner2 = new Owner();
        owner2.setFirstName("West");
        owner2.setLastName("Alan");
        owner2.setAddress("Ang Mo Kio Avenue 4");
        owner2.setCity("Singapore");
        owner2.setTelephone("11111");

        Pet finoaPet = new Pet();
        finoaPet.setPetType(savedCatPetType);
        finoaPet.setOwner(owner2);
        finoaPet.setBirthDate(LocalDate.now());
        finoaPet.setName("FinoaCat");
        owner2.getPets().add(finoaPet);

        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialities().add(radiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jessie");
        vet2.setLastName("Porter");
        vet2.getSpecialities().add(surgery);
        vetService.save(vet2);

        System.out.println("Loaded Owner");
        System.out.println("Loaded Vet");
        System.out.println("Loaded PetType");
    }
}
