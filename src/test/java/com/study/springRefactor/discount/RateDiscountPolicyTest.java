package com.study.springRefactor.discount;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {

    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000);

    }

    
    //실페 테스트 케이스 작성
    @Test
    @DisplayName("VIP가 아니면 할인 적용 x")
    void vip_x(){
        Member member = new Member(2L, "basicMember", Grade.BASIC);
        int discount = discountPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(0);
    }
}