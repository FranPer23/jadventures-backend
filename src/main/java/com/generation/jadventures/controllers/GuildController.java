package com.generation.jadventures.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.GuildConverter;
import com.generation.jadventures.dto.guild.GuildDtoBase;
import com.generation.jadventures.dto.guild.GuildDtoWWithQuest;
import com.generation.jadventures.repositories.GuildRepository;



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
        return guildConv.GuildToDtoWWithQuest(guildRepo.findById(id).get());
    }

  
    @DeleteMapping("/guilds/{id}")
    public void  deleteGuild(@PathVariable Integer id) {
         guildRepo.deleteById(id);
    }
}
