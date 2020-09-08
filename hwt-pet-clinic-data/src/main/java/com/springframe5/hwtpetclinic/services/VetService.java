package com.springframe5.hwtpetclinic.services;

import com.springframe5.hwtpetclinic.model.Owner;
import com.springframe5.hwtpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
