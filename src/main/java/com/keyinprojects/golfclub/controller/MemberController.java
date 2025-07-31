package com.keyinprojects.golfclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keyinprojects.golfclub.model.Member;
import com.keyinprojects.golfclub.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    // post
    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    // get
    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }
}
