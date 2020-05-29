package step1.domain.pricing;

import step1.domain.DiscountCondition;
import step1.domain.DiscountPolicy;
import step1.domain.Money;
import step1.domain.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
