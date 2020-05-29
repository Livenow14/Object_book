package step2.domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
