package step2.domain.pricing;


import step2.domain.DefaultDiscountPolicy;
import step2.domain.DiscountCondition;
import step2.domain.Money;
import step2.domain.Screening;

public class AmountDiscountPolicy extends DefaultDiscountPolicy {
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
