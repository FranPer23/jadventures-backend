package com.generation.jadventures.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.PartyConverter;
import com.generation.jadventures.dto.party.PartyDtoAuthentication;
import com.generation.jadventures.dto.party.PartyDtoWWithRank;
import com.generation.jadventures.entities.Party;

import com.generation.jadventures.repositories.PartyRepository;

@RestController
public class PartyController {
     @Autowired
    PartyRepository partyRepo;
    @Autowired
    PartyConverter partyConv;


    @PostMapping("/party/login")
    public ResponseEntity<?> login(@RequestBody PartyDtoAuthentication dto ){
        Optional<Party> optParty = partyRepo.login(dto.getName(), dto.getAuthentication_seal());
        if (optParty.isPresent()) {
            return new ResponseEntity<PartyDtoWWithRank>(partyConv.PartyToDtoWWithRank(optParty.get()),HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Party non trovato!",HttpStatus.UNAUTHORIZED);
        }
    }
}
