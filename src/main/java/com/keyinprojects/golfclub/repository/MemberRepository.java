package com.keyinprojects.golfclub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyinprojects.golfclub.model.Member;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByMemberName(String memberName);

    List<Member> findByMemberPhone(String memberPhone);

    List<Member> findByStartDateMembership(LocalDate startDateMembership);

    List<Member> findByMemberNameContainingIgnoreCase(String memberName);
}
