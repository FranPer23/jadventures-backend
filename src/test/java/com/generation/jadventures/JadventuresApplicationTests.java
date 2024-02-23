package com.generation.jadventures;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.entities.Quest;
import com.generation.jadventures.repositories.AdventurerRepository;
import com.generation.jadventures.repositories.QuestRepository;


@SpringBootTest
class JadventuresApplicationTests {

	@Autowired
    AdventurerRepository advRepo;



	@Test
	void contextLoads() {

		Adventurer a = Adventurer.builder()
		.name("nome avventuriero")
		.surname("cognome avventuriero")
		.dob(LocalDate.parse("2022-11-11")) 
		.rank("s")
		.role("rshtbrht")
        .build();
        a = advRepo.save(a);
	}

}


//TEST CON QUEST
// @Autowired
// QuestRepository questRepo;


// Quest q = Quest.builder()
// .date_created(LocalDate.parse("2022-11-11"))
// .status("pending")
// .rank("s")
// .reward(300)
// .area("Forest")
// .date_completed(LocalDate.parse("2022-11-13"))
// .map_url("https://example.com/map")
// .description("nhsbotijhmbsoert")
// .type("rshtbrht")
// // .patron()
// .build();
// q = questRepo.save(q);

 
