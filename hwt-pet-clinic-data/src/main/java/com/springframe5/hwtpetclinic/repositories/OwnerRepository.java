package com.springframe5.hwtpetclinic.repositories;

import com.springframe5.hwtpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastname);

    List<Owner> findAllByLastNameLike(String lastname);
}
