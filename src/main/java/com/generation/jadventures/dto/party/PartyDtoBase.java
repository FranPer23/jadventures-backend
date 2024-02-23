package com.generation.jadventures.dto.party;

import java.util.List;

import com.generation.jadventures.entities.Adventurer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PartyDtoBase {
  
    private int id;
    private String name;
    private String authentication_seal;
    private String motto;


    private Adventurer party_leader;

    private List<Adventurer> adventurers;
}
