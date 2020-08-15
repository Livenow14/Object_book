package eternity.billing.step07;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 의도를 드러내는 이름 선택하기
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
