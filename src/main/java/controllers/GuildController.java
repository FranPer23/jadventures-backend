import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.guild.GuildDtoBase;
import dto.guild.GuildDtoRpost;
import dto.guild.GuildDtoRput;
import dto.guild.GuildDtoWWithQuest;
import entities.Guild;
import respositories.GuildRepository;

@RestController
public class GuildController {
    @Autowired
    GuildRepository guildRepo;
    @Autowired
    GuildConverter guildConv;

    @GetMapping("/guilds")
    public List<GuildDtoBase> getAllGuilds() 
    {
        return guildRepo.findAll()
               .stream()
               .map(e -> guildConv.GuildToDtoBase(e))
               .toList();
    }

    @GetMapping("/guilds/{id}/quests")
    public GuildDtoWWithQuest getGuildDtoWWithQuest(@PathVariable Integer id) {
        return guildConv.GuildToDtoWplus(guildRepo.findById(id).get());
    }

    @PostMapping("/guilds")
    public Guild insertGuild(@RequestBody GuildDtoRpost dto) {
        return guildRepo.save(guildConv.GuildToDtoR(dto));
    }

    @PutMapping("/guilds/{id}")
    public GuildDtoBase updateGuild(@RequestBody GuildDtoRput dto, @PathVariable Integer id) {
        Guild g = guildConv.GuildDtoR(dto);
        g.setId(id);
        return guildConv.GuildToDtoBase(guildRepo.save(g));
    }

    @DeleteMapping("/guilds/{id}")
    public void  deleteGuild(@PathVariable Integer id) {
         guildRepo.deleteById(id);
    }
}
