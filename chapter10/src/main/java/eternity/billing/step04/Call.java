package eternity.billing.step04;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 상속을 이용해서 중복 코드 제거하기
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
