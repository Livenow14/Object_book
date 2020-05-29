package step2.domain.pricing;

import step2.domain.DefaultDiscountPolicy;
import step2.domain.DiscountCondition;
import step2.domain.Money;
import step2.domain.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
