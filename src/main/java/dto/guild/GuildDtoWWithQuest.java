package dto.guild;

import java.util.List;

import entities.Quest;
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
public class GuildDtoWWithQuest {

    private Integer id;
    private List<Quest> postedQuests;

}
