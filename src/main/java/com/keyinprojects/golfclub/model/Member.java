package com.keyinprojects.golfclub.model;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memberName;
    private String memberAddress;
    private String memberPhone;
    private String memberEmail;

    private LocalDate startDateMembership;
    private int durationMembership;

    public Member() {}

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberAddress() {
        return memberAddress;
    }

    public void setMemberAddress(String memberAddress) {
        this.memberAddress = memberAddress;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public LocalDate getStartDateMembership() {
        return startDateMembership;
    }

    public void setStartDateMembership(LocalDate startDateMembership) {
        this.startDateMembership = startDateMembership;
    }

    public int getDurationMembership() {
        return durationMembership;
    }

    public void setDurationMembership(int durationMembership) {
        this.durationMembership = durationMembership;
    }
}
