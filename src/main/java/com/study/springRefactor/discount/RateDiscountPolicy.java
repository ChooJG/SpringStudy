package com.study.springRefactor.discount;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return price * 10 / 100;
        }
        else {
            return 0;
        }
    }
}
