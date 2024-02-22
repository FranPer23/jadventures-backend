package dto.guild;

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
public class GuildDtoRpost extends GuildDtoBase{
   
    private String name;
    private String authentication_seal;
    private String seal_img_url;
    private int n_employees;
    private String hq_address;
}
