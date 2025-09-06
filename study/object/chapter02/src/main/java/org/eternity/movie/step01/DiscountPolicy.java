package org.eternity.movie.step01;

import org.eternity.money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * DiscountPolicy는 할인 여부와 요금 계산에 필요한 전체적인 흐름은 정의하지만
 * 실제로 요금을 계산 하는 부분은 추상 메서드인 getDiscountAmount 메서드에게 위임한다.
 *
 * 이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고
 * 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을
 * TEMPLATE METHOD 패턴이라고 부른다.
 */
public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening);
            }
        }

        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);
}
