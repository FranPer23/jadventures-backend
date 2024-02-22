package com.generation.jadventures.dto.guild;

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
public class GuildDtoWWithQuest extends GuildDtoBase{

    private Integer id;
    private List<Quest> postedQuests;

}
