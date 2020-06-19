package step2.domain;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
