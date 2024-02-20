package com.study.springRefactor.member;

import com.study.springRefactor.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);
}
