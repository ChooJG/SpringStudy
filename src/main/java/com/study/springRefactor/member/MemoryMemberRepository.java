package com.study.springRefactor.member;

import java.util.HashMap;
import java.util.Map;

//db가 확정되지 않았기 때문에 MemoryMemberRepository에 정보 저장
public class MemoryMemberRepository implements MemberRepository{

    //실무에선 동시성 이슈때문에 Concurrent 해쉬맵 사용해야 함
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }


}
