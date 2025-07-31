package com.keyinprojects.golfclub.controller;

import com.keyinprojects.golfclub.model.Tournament;
import com.keyinprojects.golfclub.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    @Autowired
    private TournamentService service;

    @PostMapping
    public Tournament addTournament(@RequestBody Tournament t) {
        return service.addTournament(t);
    }

    @GetMapping
    public List<Tournament> getAllTournaments() {
        return service.getAllTournaments();
    }
}
