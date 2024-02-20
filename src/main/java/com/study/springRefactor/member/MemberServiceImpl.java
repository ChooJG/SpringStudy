package com.study.springRefactor.member;

public class MemberServiceImpl implements MemberService {

    //추상화에도 의존, 구체화에도 의존하는 상태(DIP를 위반하고 있다)
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


}
