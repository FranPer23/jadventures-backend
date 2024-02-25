package com.generation.jadventures.dto.quest;

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
public class QuestDtoRput extends QuestDtoBase {
    private Integer id;
    private Integer patron;
}
