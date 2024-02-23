package com.generation.jadventures.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.generation.jadventures.converter.AdventurerConverter;
import com.generation.jadventures.repositories.AdventurerRepository;


@RestController

public class AdventurerController {
    @Autowired
    AdventurerRepository advRepo;
    @Autowired
    AdventurerConverter advConv;
}
