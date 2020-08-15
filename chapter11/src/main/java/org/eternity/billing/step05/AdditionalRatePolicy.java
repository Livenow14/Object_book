package org.eternity.billing.step05;

import org.eternity.money.Money;

/**
 * 03 합성 관계로 변경하기
 * 
 * 부가 정책 적용하기부분 
 * 4. 부가 정책을 AddtionalRatePolicy 추상 클래스로 구현 
 */
public abstract class AdditionalRatePolicy implements RatePolicy {
    private RatePolicy next;

    public AdditionalRatePolicy(RatePolicy next) {
        this.next = next;
    }

    @Override
    public Money calculateFee(Phone phone) {
        Money fee = next.calculateFee(phone);
        return afterCalculated(fee) ;
    }

    abstract protected Money afterCalculated(Money fee);
}
