package com.springframe5.hwtpetclinic.services.map;

import com.springframe5.hwtpetclinic.model.Owner;
import com.springframe5.hwtpetclinic.model.Pet;
import com.springframe5.hwtpetclinic.services.OwnerService;
import com.springframe5.hwtpetclinic.services.PetService;
import com.springframe5.hwtpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetService petService;
    private final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner owner) {
        super.delete(owner);
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner owner) {

        if(owner != null) {
            if(owner.getPets() != null) {
                owner.getPets().forEach( pet -> {
                    if (pet.getPetType() != null) {
                        if(pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }

                    if(pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }

            return super.save(owner);
        } else {
            return null;
        }
    }

    @Override
    public Owner findByLastName(String lastname) {
        return this.findAll()
                .stream()
                .filter(owner -> owner.getLastName().equalsIgnoreCase(lastname))
                .findFirst()
                .orElse(null);
    }
}
