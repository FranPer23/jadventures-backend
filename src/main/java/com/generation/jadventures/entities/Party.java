package com.generation.jadventures.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Party {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String authentication_seal;
    private String motto;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "party_leader_id")
    private Adventurer party_leader;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Adventurer> adventurers;

    
}
