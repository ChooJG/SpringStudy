package com.study.springRefactor.discount;

import com.study.springRefactor.member.Grade;
import com.study.springRefactor.member.Member;

public class FixDiscoountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        else{
            return 0;
        }
    }
}
