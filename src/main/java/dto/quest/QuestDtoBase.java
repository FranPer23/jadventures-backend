package dto.quest;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class QuestDtoBase {
  
    private Date date_created;
    private String status;
    private String rank;
    private int reward;
    private String area;
    private Date date_completed;
    private String map_url;
    private String description;
    private String type;

}
