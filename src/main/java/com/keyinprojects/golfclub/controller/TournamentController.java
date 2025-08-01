package com.keyinprojects.golfclub.controller;

import com.keyinprojects.golfclub.model.Member;
import com.keyinprojects.golfclub.model.Tournament;
import com.keyinprojects.golfclub.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

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

    @PostMapping("/{tournamentId}/members/{memberId}")
    public Tournament addMember(@PathVariable Long tournamentId,
                                @PathVariable Long memberId) {
        return service.addMemberToTournament(tournamentId, memberId);
    }

    @GetMapping("/search")
    public List<Tournament> searchTournaments(
            @RequestParam(required = false)
            @DateTimeFormat(iso = DATE) LocalDate date,
            @RequestParam(required = false) String location) {

        if (date != null) {
            return service.getByStartDate(date);
        }
        if (location != null) {
            return service.getByLocation(location);
        }
        return service.getAllTournaments();
    }

    @GetMapping("/{id}/members")
    public Set<Member> listMembers(@PathVariable Long id) {
        return service.getMembersInTournament(id);
    }
}
