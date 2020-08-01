package movie.step02.pricing;


import money.Money;
import movie.step02.DiscountPolicy;
import movie.step02.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
