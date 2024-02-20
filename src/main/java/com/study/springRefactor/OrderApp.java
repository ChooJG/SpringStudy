package com.study.springRefactor;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;
import com.study.springRefactor.member.MemberService;
import com.study.springRefactor.member.MemberServiceImpl;
import com.study.springRefactor.order.Order;
import com.study.springRefactor.order.OrderService;
import com.study.springRefactor.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "newMember", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ABC", 10000);

        System.out.println("order : " + order);
        System.out.println("order.calculatePrice : " + order.calculatePrice());


    }
}
