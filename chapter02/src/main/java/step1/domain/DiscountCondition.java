package step1.domain;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}
