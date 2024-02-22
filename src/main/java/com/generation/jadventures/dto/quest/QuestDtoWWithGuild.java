package com.generation.jadventures.dto.quest;

import com.generation.jadventures.entities.Guild;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = false)
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class QuestDtoWWithGuild extends QuestDtoBase {
    private Integer id;
    private Guild patron;
    
}
