package com.springframe5.hwtpetclinic.bootstrap;

import com.springframe5.hwtpetclinic.model.Owner;
import com.springframe5.hwtpetclinic.model.PetType;
import com.springframe5.hwtpetclinic.model.Vet;
import com.springframe5.hwtpetclinic.services.OwnerService;
import com.springframe5.hwtpetclinic.services.PetTypeService;
import com.springframe5.hwtpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }


    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstname("West");
        owner2.setLastname("Alan");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstname("Jessie");
        vet2.setLastname("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Owner");
        System.out.println("Loaded Vet");
        System.out.println("Loaded PetType");
    }
}
