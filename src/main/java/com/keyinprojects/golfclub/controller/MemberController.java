package com.keyinprojects.golfclub.controller;

import com.keyinprojects.golfclub.model.Member;
import com.keyinprojects.golfclub.repository.MemberRepository;
import com.keyinprojects.golfclub.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepo;

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/search")
    public List<Member> search(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phone,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DATE) LocalDate startDate) {

        if (name != null)
            return memberRepo.findByMemberNameContainingIgnoreCase(name);

        if (phone != null)
            return memberRepo.findByMemberPhone(phone);

        if (startDate != null)
            return memberRepo.findByStartDateMembership(startDate);

        return memberRepo.findAll();
    }
}
