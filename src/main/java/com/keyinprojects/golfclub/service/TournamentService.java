package com.keyinprojects.golfclub.service;

import com.keyinprojects.golfclub.model.Tournament;
import com.keyinprojects.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository repo;

    public Tournament addTournament(Tournament t) {
        return repo.save(t);
    }

    public List<Tournament> getAllTournaments() {
        return repo.findAll();
    }
}
