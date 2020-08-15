package org.eternity.billing.step05;

import org.eternity.money.Money;

/**
 * 2. 기본 정책 구현,
 * 기본 정책을 구성하는 일반 요금제와 심야 할인 요금제는 개별 요금 외에 전체 처리 로직이 거의 동일 
 */
public abstract class BasicRatePolicy implements RatePolicy {
    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for(Call call : phone.getCalls()) {
            result.plus(calculateCallFee(call));
        }

        return result;
    }

    protected abstract Money calculateCallFee(Call call);
}
