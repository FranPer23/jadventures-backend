package com.generation.jadventures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jadventures.entities.Party;

public interface PartyRepository extends JpaRepository<Party, Integer> {

}
