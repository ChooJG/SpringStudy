package com.study.springRefactor.beanfind;

import com.study.springRefactor.AppConfig;
import com.study.springRefactor.discount.DiscountPolicy;
import com.study.springRefactor.discount.FixDiscoountPolicy;
import com.study.springRefactor.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestClass.class);


    @Test
    @DisplayName("부모 빈으로 조회시, 자식이 둘 이상이면 중복 오류")
    void findBeanByParentType(){
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> ac.getBean(DisplayName.class));
    }

    @Test
    @DisplayName("부모 빈으로 조회시, 자식이 둘 이상이면 빈 이름으로 조회")
    void findBeanByParentName(){
        DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회")
    void findBySubType(){
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 전부 조회")
    void findAllBeanByParentType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);

    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기 -Object")
    void findBeanByParentObject(){
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String s : beansOfType.keySet()) {
            System.out.println("s = " + s);
        }
    }


    @Configuration
    static class TestClass{

        @Bean
        public DiscountPolicy rateDiscountPolicy(){
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy(){
            return new FixDiscoountPolicy();
        }
    }

}
