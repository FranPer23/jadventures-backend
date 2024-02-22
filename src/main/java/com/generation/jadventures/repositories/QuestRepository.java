package com.generation.jadventures.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.jadventures.entities.Quest;


public interface QuestRepository extends JpaRepository<Quest, Integer>{

}
