package step1.domain.pricing;


import step2.domain.DiscountPolicy;
import step2.domain.Money;
import step2.domain.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }

    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return null;
    }
}
