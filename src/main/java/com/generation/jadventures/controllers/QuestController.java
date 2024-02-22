package com.generation.jadventures.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.QuestConverter;
import com.generation.jadventures.dto.quest.QuestDtoRpost;
import com.generation.jadventures.dto.quest.QuestDtoWWithGuild;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.repositories.QuestRepository;



@RestController
public class QuestController {
    @Autowired
    QuestRepository questRepo;
    @Autowired
    QuestConverter questConv;

    @GetMapping("/quests")
    public List<QuestDtoWWithGuild> getAll() 
    {
        return questRepo.findAll().stream().map(q -> questConv.questToDtoWWithGuild(q)).toList();
    }

    @PostMapping("/quests")
    public QuestDtoWWithGuild insert(@RequestBody QuestDtoRpost dto) 
    {
        Quest q = questConv.questDtoPost(dto);
        return questConv.questToDtoWWithGuild(questRepo.save(q));
    }
   
    

    // @PostMapping("/quests")
    // public QuestDtoRpost insert(@RequestBody QuestDtoRpost dto) 
    // {
    //     Quest q = questConv.questDtoPost(dto);
    //     return questConv.questDtoPost(questRepo.save(q));
    // }

    @DeleteMapping("/quests/{id}")
    public void  deleteQuest(@PathVariable Integer id) 
    {
        questRepo.deleteById(id);
    }
 
}


