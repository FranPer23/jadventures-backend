package com.generation.jadventures.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.jadventures.entities.Guild;


public interface GuildRepository extends JpaRepository<Guild, Integer>

{
    @Query(value="SELECT * FROM guild WHERE name= :name AND authentication_seal= :seal")
    Optional<Guild> login (@Param("name") String name, @Param ("seal") String seal);
}

