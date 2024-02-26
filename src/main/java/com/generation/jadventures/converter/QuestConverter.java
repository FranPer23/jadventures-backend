package com.generation.jadventures.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.jadventures.dto.quest.QuestDtoBase;
import com.generation.jadventures.dto.quest.QuestDtoR;
import com.generation.jadventures.dto.quest.QuestDtoRpost;
import com.generation.jadventures.dto.quest.QuestDtoRput;
import com.generation.jadventures.dto.quest.QuestDtoWWithGuild;
import com.generation.jadventures.entities.Guild;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.repositories.GuildRepository;
import com.generation.jadventures.repositories.QuestRepository;




// id;
// date_created;
// status;
// rank;
// reward;
// area;
// date_completed;
// map_url;
// description;
// type;

@Service
public class QuestConverter {
    @Autowired
    QuestRepository questRepo;
    @Autowired
    GuildRepository guildRepo;




    public Quest QuestDtoR(QuestDtoR dto){
        return Quest
        .builder()
        .date_created(dto.getDate_created())
        .status(dto.getStatus())
        .rank(dto.getRank())
        .reward(dto.getReward())
        .area(dto.getArea())
        .date_completed(dto.getDate_completed())
        .map_url(dto.getMap_url())
        .description(dto.getDescription())
        .type(dto.getType())
        .build();

}

public QuestDtoBase QuestToDtoBase(Quest e){
    return QuestDtoBase
    .builder()
    .date_created(e.getDate_created())
    .status(e.getStatus())
    .rank(e.getRank())
    .reward(e.getReward())
    .area(e.getArea())
    .date_completed(e.getDate_completed())
    .map_url(e.getMap_url())
    .description(e.getDescription())
    .type(e.getType())
    .build();

}

public QuestDtoWWithGuild questToDtoWWithGuild(Quest e){
    return QuestDtoWWithGuild    
    .builder()
    .id(e.getId())
    .date_created(e.getDate_created())
    .status(e.getStatus())
    .rank(e.getRank())
    .reward(e.getReward())
    .area(e.getArea())
    .date_completed(e.getDate_completed())
    .map_url(e.getMap_url())
    .description(e.getDescription())
    .type(e.getType())
    .patron(e.getPatron())
    .build();
}

public Quest questDtoPost(QuestDtoRpost dto){
    return Quest
                .builder()
                .date_created(dto.getDate_created())
                .status(dto.getStatus())
                .rank(dto.getRank())
                .reward(dto.getReward())
                .area(dto.getArea())
                .date_completed(dto.getDate_completed())
                .map_url(dto.getMap_url())
                .description(dto.getDescription())
                .type(dto.getType())
                .patron(guildRepo.findById(dto.getPatron()).get())
            .build();
}

public Quest questDtoPut(QuestDtoRput dto){
    Guild gilda = guildRepo.findById(dto.getPatron()).get();
    return Quest
    .builder()
    .date_created(dto.getDate_created())
    .status(dto.getStatus())
    .rank(dto.getRank())
    .reward(dto.getReward())
    .area(dto.getArea())
    .date_completed(dto.getDate_completed())
    .map_url(dto.getMap_url())
    .description(dto.getDescription())
    .type(dto.getType())
    .patron(gilda)
    .build();
}
}
