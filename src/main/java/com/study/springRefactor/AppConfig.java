package com.study.springRefactor;

import com.study.springRefactor.discount.DiscountPolicy;
import com.study.springRefactor.discount.FixDiscoountPolicy;
import com.study.springRefactor.discount.RateDiscountPolicy;
import com.study.springRefactor.member.MemberRepository;
import com.study.springRefactor.member.MemberService;
import com.study.springRefactor.member.MemberServiceImpl;
import com.study.springRefactor.member.MemoryMemberRepository;
import com.study.springRefactor.order.OrderService;
import com.study.springRefactor.order.OrderServiceImpl;

//어플리케이션에 대한 모든 환경설정을 하는 공간
public class AppConfig {

    //생성자 주입 (구체 클래스 주입)
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
