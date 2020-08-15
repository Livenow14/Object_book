package org.eternity.billing.step05;

import org.eternity.money.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기본 정책을 이용해 요금을 계산할 수 있도록 Phone수정
 * RatePolicy에 대한 참조자가 포함되어있다. 이를 합성이라 부른다.
 */
public class Phone {
    private RatePolicy ratePolicy;
    private List<Call> calls = new ArrayList<>();

    public Phone(RatePolicy ratePolicy) {
        this.ratePolicy = ratePolicy;
    }

    public List<Call> getCalls() {
        return Collections.unmodifiableList(calls);
    }

    public Money calculateFee() {
        return ratePolicy.calculateFee(this);
    }
}
