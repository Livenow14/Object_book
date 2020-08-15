package org.eternity.billing.step04;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 그림과 같이 만들기위해 클래스가 많이 늘어남
 * 기본 정책에 기본 요금 할인 정책 조합하기부분 
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
