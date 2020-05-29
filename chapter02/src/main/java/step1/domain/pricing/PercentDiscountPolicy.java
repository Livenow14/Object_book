package step1.domain.pricing;

import step1.domain.DiscountCondition;
import step1.domain.DiscountPolicy;
import step1.domain.Money;
import step1.domain.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
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
