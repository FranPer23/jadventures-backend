package com.generation.jadventures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jadventures.entities.Adventurer;

public interface AdventurerRepository extends JpaRepository<Adventurer, Integer>{

}
