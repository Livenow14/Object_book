package org.eternity.billing.step05;

import org.eternity.money.Money;

/**
 * 기본 정책 함성하기
 * 1. 기본 정책과 부가 정책을 포관하는 인터페이스
 */
public interface RatePolicy {
    Money calculateFee(Phone phone);
}
