package com.generation.jadventures.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.QuestConverter;

import com.generation.jadventures.dto.quest.QuestDtoRpost;
import com.generation.jadventures.dto.quest.QuestDtoRput;
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

    @GetMapping("/quests/{id}")
    public ResponseEntity<?> questDetails(@PathVariable Integer id) {
    Optional<Quest> quest = questRepo.findById(id);
    if (quest.isPresent()) {
        return ResponseEntity.ok(questConv.questToDtoWWithGuild(quest.get()));
    } else {
        return ResponseEntity.notFound().build();
    }
}
    @PostMapping("/quests")
    public Quest insert(@RequestBody QuestDtoRpost dto) 
    {
        return questRepo.save(questConv.questDtoPost(dto));
    }
   
    
    @PutMapping("/quests/{id}")
    public QuestDtoWWithGuild edit(@RequestBody QuestDtoRput dto) 
    {
        Quest q = questConv.questDtoPut(dto);
        return questConv.questToDtoWWithGuild(questRepo.save(q));
    }

    @DeleteMapping("/quests/{id}")
    public void  deleteQuest(@PathVariable Integer id) 
    {
        questRepo.deleteById(id);
    }
 
}


