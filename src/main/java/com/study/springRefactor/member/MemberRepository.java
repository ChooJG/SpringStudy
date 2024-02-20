package com.study.springRefactor.member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long id);
}
