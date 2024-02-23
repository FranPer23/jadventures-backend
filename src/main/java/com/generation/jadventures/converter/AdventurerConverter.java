package com.generation.jadventures.converter;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.generation.jadventures.dto.adventurer.AdventurerDtoBase;
import com.generation.jadventures.entities.Adventurer;

// private int id;
// private String name;
// private String surname;
// private LocalDate dob; 
// private String rank;
// private String role;

// private Party party;

@Service

public class AdventurerConverter {

    public AdventurerDtoBase AdventurerToDtoBase (Adventurer e){
        return AdventurerDtoBase
        .builder()
        .id(e.getId())
        .name(e.getName())
        .surname(e.getSurname())
        .dob(LocalDate.of(e.getDob().getYear(), e.getDob().getMonth(), e.getDob().getDayOfMonth()))
        .rank(e.getRank())
        .role(e.getRole())
        .build();
    }
}
