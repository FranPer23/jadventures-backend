package com.generation.jadventures.dto.adventurer;

import java.time.LocalDate;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.generation.jadventures.entities.Party;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class AdventurerDtoBase {
 
    private int id;
    private String name;
    private String surname;
    private LocalDate dob; 
    private String rank;
    private String role;

    private Party party;
}
