import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dto.quest.QuestDtoBase;
import dto.quest.QuestDtoR;
import entities.Quest;
import respositories.QuestRepository;

@RestController
public class QuestController {
    @Autowired
    QuestRepository questRepo;
    @Autowired
    QuestConverter questConv;

    @GetMapping("/quests")
    public List<QuestDtoBase> getAllQuests() 
    {
        return questRepo.findAll()
               .stream()
               .map(e -> questConv.QuestToDtoBase(e))
               .toList();
    }

    // @GetMapping("/quests/{id}/-----")
    // public QuestDtoWplus getQuestDtoWplus(@PathVariable Integer id) {
    //     return questConv.QuestToDtoWplus(questRepo.findById(id).get());
    // }

    @PostMapping("/quests")
    public Quest insertQuest(@RequestBody QuestDtoR dto) {
        return questRepo.save(questConv.QuestToDtoR(dto));
    }

    @PutMapping("/quests/{id}")
    public QuestDtoBase updateQuest(@RequestBody QuestDtoR dto,@PathVariable Integer id) {
        Quest p = questConv.QuestDtoR(dto);
        p.setId(id);
        return questConv.QuestToDtoBase(questRepo.save(p));
    }

    @DeleteMapping("/quests/{id}")
    public void  deleteQuest(@PathVariable Integer id) {
         questRepo.deleteById(id);
    }
}
