package eternity.billing.step02;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 중복 코드 수정하기
 * 세율을 위해 taxRate 추가 
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
