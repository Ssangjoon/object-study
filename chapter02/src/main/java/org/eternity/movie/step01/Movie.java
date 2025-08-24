package org.eternity.movie.step01;

import org.eternity.money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    /**
     * 코드 수준에서 Movie 클래스는 추상클래스(DiscountPolicy)를 의존한다.
     * 그러나 실행 시점에는 구체 클래스(AmountDiscountPolicy, PercentDiscountPolicy, NoneDiscountPolicy)를 의존하게 된다.
     *
     * 이처럼 코드의 의존성과 실행 시점의 의존성은 다를 수 있다.
     *
     * 1. 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드를 이 해하기 어려워진다.
     *  코드를 이해하기 위해서는 코드뿐만 아니라 객체를 생성하고 연결하는 부분을 찾아야 하기 때문이다.
     * 2. 반면 코드의 의존성과 실행 시점의 의존성이 다르면 다를수록 코드는 더 유연해지고 확장 가능해진다.
     *
     * 이와 같은 의존성의 양면성은 설계가 트레이드오프의 산물이라는 사실을 잘 보여준다.
     *
     */
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

