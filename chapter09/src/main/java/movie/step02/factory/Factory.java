package movie.step02.factory;



import money.Money;
import movie.step02.Movie;
import movie.step02.pricing.AmountDiscountPolicy;
import movie.step02.pricing.SequenceCondition;

import java.time.Duration;

public class Factory {
    public Movie createAvatarMovie() {
        return new Movie("아바타",
                Duration.ofMinutes(120),
                Money.wons(10000),
                new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(10)));
    }
}
