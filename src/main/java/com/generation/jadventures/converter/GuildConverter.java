package com.generation.jadventures.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jadventures.dto.guild.GuildDtoBase;
import com.generation.jadventures.dto.guild.GuildDtoR;
import com.generation.jadventures.dto.guild.GuildDtoWWithQuest;
import com.generation.jadventures.entities.Guild;


// id;
// name;
// authentication_seal;
// seal_img_url;
// n_employees;
// hq_address;

@Service
public class GuildConverter {
    @Autowired
    QuestConverter quetConv;

    public Guild GuildDtoR (GuildDtoR e){
        return Guild 
        .builder()
        .id(e.getId())
        .name(e.getName())
        .authentication_seal(e.getAuthentication_seal())
        .seal_img_url(e.getSeal_img_url())
        .n_employees(e.getN_employees())
        .hq_address(e.getHq_address())
        .build();
    }

    public GuildDtoBase GuildToDtoBase (Guild e){
        return GuildDtoBase
        .builder()
        .id(e.getId())
        .name(e.getName())
        .authentication_seal(e.getAuthentication_seal())
        .seal_img_url(e.getSeal_img_url())
        .n_employees(e.getN_employees())
        .hq_address(e.getHq_address())
        .build();
    }

    public GuildDtoWWithQuest GuildToDtoWWithQuest(Guild e){
        return GuildDtoWWithQuest
        .builder()
        .id(e.getId())
        .name(e.getName())
        .authentication_seal(e.getAuthentication_seal())
        .seal_img_url(e.getSeal_img_url())
        .n_employees(e.getN_employees())
        .hq_address(e.getHq_address())
        .postedQuests(e.getPostedQuests())
        .build();
    }



}
