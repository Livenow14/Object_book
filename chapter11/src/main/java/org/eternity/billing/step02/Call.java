package org.eternity.billing.step02;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 기본 정책에 세금 정책 조합하기
 * 자식 클래스와 부모 클래스 사이의 결합도가 높아짐 
 */
public class Call {
    private LocalDateTime from;
    private LocalDateTime to;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public Duration getDuration() {
        return Duration.between(from, to);
    }

    public LocalDateTime getFrom() {
        return from;
    }
}
