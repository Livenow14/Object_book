package step2.domain.pricing;

import step2.domain.DiscountPolicy;
import step2.domain.Money;
import step2.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
