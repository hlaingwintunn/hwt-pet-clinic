package com.springframe5.hwtpetclinic.repositories;

import com.springframe5.hwtpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
