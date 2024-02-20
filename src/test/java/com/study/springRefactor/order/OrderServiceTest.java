package com.study.springRefactor.order;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;
import com.study.springRefactor.member.MemberService;
import com.study.springRefactor.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "newMember", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "ABC", 10000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);


    }
}
