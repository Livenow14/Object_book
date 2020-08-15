package org.eternity.billing.step03;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 결합도를 낮추기 위해 부모클래스에서 추상 메서드 재공 
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
