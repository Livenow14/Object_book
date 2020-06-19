package step1.domain;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();     //하나의 할인 정책에 여러개의 할인 조건을 포함

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

    /**
     * 이처럼 부모 클래스에 기본적인 알고리즘의 흐름을 구현하고 중간에 필요한 처리를 자식 클래스에게 위임하는 디자인 패턴을
     * TEMPLATE METHOD 패턴이라 부른다.
     */
    abstract protected Money getDiscountAmount(Screening Screening);
}
