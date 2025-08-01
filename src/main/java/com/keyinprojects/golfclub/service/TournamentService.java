package com.keyinprojects.golfclub.service;

import com.keyinprojects.golfclub.model.Member;
import com.keyinprojects.golfclub.model.Tournament;
import com.keyinprojects.golfclub.repository.MemberRepository;
import com.keyinprojects.golfclub.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class TournamentService {

    @Autowired
    private TournamentRepository tourRepo;

    @Autowired
    private MemberRepository memberRepo;

    public Tournament addTournament(Tournament t) {
        return tourRepo.save(t);
    }

    public List<Tournament> getAllTournaments() {
        return tourRepo.findAll();
    }

    public List<Tournament> getByStartDate(LocalDate d) {
        return tourRepo.findByStartDate(d);
    }

    public List<Tournament> getByLocation(String loc) {
        return tourRepo.findByLocationContainingIgnoreCase(loc);
    }

    public Tournament addMemberToTournament(Long tourId, Long memberId) {
        Tournament tour = tourRepo.findById(tourId)
                .orElseThrow(() -> new RuntimeException("Tournament not found"));

        Member mem = memberRepo.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        tour.getParticipatingMembers().add(mem);
        return tourRepo.save(tour);
    }

    public Set<Member> getMembersInTournament(Long id) {
    return tourRepo.findById(id)
                   .orElseThrow(() -> new RuntimeException("Not found"))
                   .getParticipatingMembers();
    }
}
