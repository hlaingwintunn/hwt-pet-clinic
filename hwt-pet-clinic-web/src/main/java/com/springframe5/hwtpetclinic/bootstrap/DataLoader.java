package com.springframe5.hwtpetclinic.bootstrap;

import com.springframe5.hwtpetclinic.model.Owner;
import com.springframe5.hwtpetclinic.model.Vet;
import com.springframe5.hwtpetclinic.services.OwnerService;
import com.springframe5.hwtpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstname("Michael");
        owner1.setLastname("Weston");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstname("West");
        owner2.setLastname("Alan");
        ownerService.save(owner2);

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstname("Sam");
        vet1.setLastname("Axe");
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstname("Jessie");
        vet2.setLastname("Porter");
        vetService.save(vet2);

        System.out.println("Loaded Owner");
        System.out.println("Loaded Vet");
    }
}
