package com.keyinprojects.golfclub.service;

import com.keyinprojects.golfclub.model.Member;
import com.keyinprojects.golfclub.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepo;

    public Member addMember(Member m) {
        return memberRepo.save(m);
    }

    public List<Member> getAllMembers() {
        return memberRepo.findAll();
    }
}
