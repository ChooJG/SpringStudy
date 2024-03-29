package com.study.springRefactor;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;
import com.study.springRefactor.member.MemberService;
import com.study.springRefactor.member.MemberServiceImpl;
import com.study.springRefactor.order.Order;
import com.study.springRefactor.order.OrderService;
import com.study.springRefactor.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);


        Long memberId = 1L;
        Member member = new Member(memberId, "newMember", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ABC", 11000);

        System.out.println("order : " + order);
        System.out.println("order.calculatePrice : " + order.calculatePrice());


    }
}
