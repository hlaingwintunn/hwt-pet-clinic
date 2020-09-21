package com.springframe5.hwtpetclinic.repositories;

import com.springframe5.hwtpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);
}
