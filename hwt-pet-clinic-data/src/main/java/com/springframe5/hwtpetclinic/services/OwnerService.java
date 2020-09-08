package com.springframe5.hwtpetclinic.services;

import com.springframe5.hwtpetclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastname);
}
