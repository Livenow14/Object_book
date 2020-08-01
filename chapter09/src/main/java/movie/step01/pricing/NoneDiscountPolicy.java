package movie.step01.pricing;


import money.Money;
import movie.step01.DiscountPolicy;
import movie.step01.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
