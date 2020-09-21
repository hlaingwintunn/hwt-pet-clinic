package com.springframe5.hwtpetclinic.repositories;

import com.springframe5.hwtpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
