package step1.domain.pricing;


import step1.domain.DiscountPolicy;
import step1.domain.Money;
import step1.domain.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
