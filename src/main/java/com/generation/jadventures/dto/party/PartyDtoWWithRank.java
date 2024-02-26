package com.generation.jadventures.dto.party;

import java.util.List;

import com.generation.jadventures.entities.Quest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper=false)

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class PartyDtoWWithRank extends PartyDtoBase{
   
    private Integer id;
    private String partyRank;
    private List <Quest> quests;
}
