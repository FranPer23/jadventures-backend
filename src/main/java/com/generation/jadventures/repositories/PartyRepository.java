package com.generation.jadventures.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.generation.jadventures.entities.Party;

public interface PartyRepository extends JpaRepository<Party, Integer> {
    @Query(value="SELECT * FROM party WHERE name= :name AND authentication_seal= :seal", nativeQuery=true)
    Optional<Party> login (@Param("name") String name, @Param ("seal") String seal);
}
