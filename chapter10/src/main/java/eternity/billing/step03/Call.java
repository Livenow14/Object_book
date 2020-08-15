package eternity.billing.step03;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 타입 코드 사용하기
 * 이는 낮은 응집도와 높은 결합도라는 문제에 시달리게됨 
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
