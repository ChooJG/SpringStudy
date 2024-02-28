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
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//어플리케이션에 대한 모든 환경설정을 하는 공간
@Configuration
public class AppConfig {

    //생성자 주입 (구체 클래스 주입)
    //Bean 어노테이션을 붙이면 스프링 컨테이너(?) 라는 곳에 등록이 된다.
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }
}
