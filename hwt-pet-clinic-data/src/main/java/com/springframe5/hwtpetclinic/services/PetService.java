package com.springframe5.hwtpetclinic.services;

import com.springframe5.hwtpetclinic.model.Owner;
import com.springframe5.hwtpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
