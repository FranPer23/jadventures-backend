package com.generation.jadventures.converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.generation.jadventures.dto.party.PartyDtoBase;
import com.generation.jadventures.dto.party.PartyDtoWWithRank;
import com.generation.jadventures.entities.Adventurer;
import com.generation.jadventures.entities.Party;



@Service

    
    //  id;
    //  name;
    //  authentication_seal;
    //  motto;
    //  party_leader;
    //  adventurers;
    //  quests;

public class PartyConverter {

    @Autowired
    QuestConverter quetConv;

 
    
    public  PartyDtoBase PartyToDtoBase(Party e){
        return PartyDtoBase
        .builder()
        .name(e.getName())
        .authentication_seal(e.getAuthentication_seal())
        .motto(e.getMotto())
        .party_leader(e.getParty_leader())
        .adventurers(e.getAdventurers())
        .build();
   

    }

        
    public  PartyDtoWWithRank PartyToDtoWWithRank (Party e){
        return PartyDtoWWithRank
        .builder()
        .id(e.getId())
        .name(e.getName())
        .authentication_seal(e.getAuthentication_seal())
        .motto(e.getMotto())
        .party_leader(e.getParty_leader())
        .adventurers(e.getAdventurers())
        .quests(e.getQuests())
        .partyRank(calculatePartyRank(e))
        .build();
   

    }


    private static final Map<String, Integer> RANK_VALUES = new HashMap<>();
    static {
        RANK_VALUES.put("S", 5);
        RANK_VALUES.put("A", 4);
        RANK_VALUES.put("B", 3);
        RANK_VALUES.put("C", 2);
        RANK_VALUES.put("D", 1);
    }

    public String calculatePartyRank(Party party) {
        List<Adventurer> adventurers = party.getAdventurers();
        int totalAdventurers = adventurers.size();
        double totalRank = 0;

        // Trova il rank dell'avventuriero più debole nel party
        double weakestAdventurerRank = Double.MAX_VALUE;
        for (Adventurer adventurer : adventurers) {
            String rank = adventurer.getRank();
            if (RANK_VALUES.containsKey(rank)) {
                double adventurerRankValue = RANK_VALUES.get(rank);
                if (adventurerRankValue < weakestAdventurerRank) {
                    weakestAdventurerRank = adventurerRankValue;
                }
            }
        }

        // Calcola la media dei rank degli altri avventurieri e del party leader
        for (Adventurer adventurer : adventurers) {
            String rank = adventurer.getRank();
            if (RANK_VALUES.containsKey(rank)) {
                totalRank += RANK_VALUES.get(rank);
            } else {
                // Tratta il rank non valido come un valore minimo
                totalRank += 1;
            }
        }
        // Aggiungi il rank del party leader
        Adventurer partyLeader = party.getParty_leader();
        if (partyLeader != null) {
            String leaderRank = partyLeader.getRank();
            if (RANK_VALUES.containsKey(leaderRank)) {
                totalRank += RANK_VALUES.get(leaderRank);
            } else {
                // Tratta il rank non valido come un valore minimo
                totalRank += 1;
            }
        }

        // Calcola la media
        double averageRank = (weakestAdventurerRank + totalRank) / (totalAdventurers + 1);

        // Converti il valore numerico medio in una stringa rappresentante il rank corrispondente
        String averageRankString;
        if (averageRank >= 4.5) {
            averageRankString = "S";
        } else if (averageRank >= 3.5) {
            averageRankString = "A";
        } else if (averageRank >= 2.5) {
            averageRankString = "B";
        } else if (averageRank >= 1.5) {
            averageRankString = "C";
        } else {
            averageRankString = "D";
        }

        return averageRankString;
    }
}
