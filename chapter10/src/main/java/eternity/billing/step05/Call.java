package eternity.billing.step05;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 강하게 결합된 Phone과 NightlyDiscountPhone
 * w자식 클래스가 부모 클래스와 구현에 강하게 결합될 경우 부모 클래스의 변경에 의해
 * 자식 클래스가 영향을 받는다는 사실을 보여주는 예제
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
