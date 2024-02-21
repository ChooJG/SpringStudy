package com.study.springRefactor.order;

import com.study.springRefactor.discount.DiscountPolicy;
import com.study.springRefactor.discount.FixDiscoountPolicy;
import com.study.springRefactor.discount.RateDiscountPolicy;
import com.study.springRefactor.member.Member;
import com.study.springRefactor.member.MemberRepository;
import com.study.springRefactor.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{


    //private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscoountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    
    //구현에 의존하지 않고 인터페이스(추상)에만 의존 (DIP 지킴)
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
