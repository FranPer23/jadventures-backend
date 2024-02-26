package com.generation.jadventures.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.GuildConverter;
import com.generation.jadventures.dto.guild.GuildDtoAuthentication;
import com.generation.jadventures.dto.guild.GuildDtoBase;
import com.generation.jadventures.dto.guild.GuildDtoWWithQuest;
import com.generation.jadventures.dto.guild.GuildDtoWithImg;
import com.generation.jadventures.entities.Guild;
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
    
    @PostMapping("/guilds/login")
    public ResponseEntity<?> login(@RequestBody GuildDtoAuthentication dto ){
        Optional<Guild> optGuild = guildRepo.login(dto.getName(), dto.getAuthentication_seal());
        if (optGuild.isPresent()) {
            return new ResponseEntity<GuildDtoWithImg>(guildConv.GuildToDtoWWithImg(optGuild.get()),HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Gilda non trovata!",HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/guilds/{id}/quests")
    public GuildDtoWWithQuest getGuildDtoWWithQuest(@PathVariable Integer id) {
        return guildConv.GuildToDtoWWithQuest(guildRepo.findById(id).get());
    }

    @GetMapping("/guilds/{id}")
    public GuildDtoBase getGuildDtoBase(@PathVariable Integer id) {
        return guildConv.GuildToDtoBase(guildRepo.findById(id).get());
    }

  
    @DeleteMapping("/guilds/{id}")
    public void  deleteGuild(@PathVariable Integer id) {
         guildRepo.deleteById(id);
    }
}
