package step2.domain;

import java.time.Duration;

/**
 * 어떤 할인 정책을 사용할 것인지 결정하는 코드가 어디에도 존재하지 않는다.
 * 단지 DiscountPolicy에게 메세지를 전송할 뿐이다.
 * 여기에는 객체지향에서 중요하다고 여겨지는 두 가지 개념이 숨겨져 잇다. 하나는 상속(inheritance)이고 다른 하나는 다형성이다.
 * 그리고 그 기반에는 추상화(abstraction)라는 원리가 숨겨져 있다.
 */
public class Movie {
    private String title;       //제목
    private Duration runningTime;       //상영시간
    private Money fee;      //기본요금
    private DiscountPolicy discountPolicy;      //할인정책

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    /**
     * calculateMovieFee 메서드는 discountPolicy에 calculateDiscountAmount 메세지를 전송해 할인 요금을 반환 받는다.
     */
    public Money calculateMovieFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

    public void changeDiscountPolicy(DiscountPolicy discountPolicy){
        this.discountPolicy = discountPolicy;
    }
}

