package step1.domain;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    /**
     * 하나의 영화에 대해 단 하나의 할인정책만 설정할 수 있기 때문에 Moice와 DiscountPolicy의 생성자는 이런 제약을 강제한다.
     * Movie의 생성자는 오직 하나의 DiscountPolicy 인스턴스만 받을 수 있도록 선언돼 있다.
     * 반면 DiscountPolicy 생성자는 여러 개의 DiscountCondition 인스턴스를 허용한다.
     */
    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}

