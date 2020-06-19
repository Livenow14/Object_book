package step2.domain;

import java.time.LocalDateTime;

/**
 * 여기서 주목할 점은 인스턴스 변수의 가시성(접근 지정자)은 private이고 메서드의 가시성은 public이라는 점이다.
 * 이와같이 클래스의 내부와 외부를 분리해야한다.
 */
public class Screening {        //상영
    private Movie movie;        //영화
    private int sequence;       //순번
    private LocalDateTime whenScreened;     //상영 시작 시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }       //상영 시작 시간 반환

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }       //순번의 일치 여부

    public Money getMovieFee() {
        return movie.getFee();
    }       //기본 요금 반환

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount),
                audienceCount);
    }

    /**
     * Screening이 Movie에게 calculateFee 메세지를 전송한다.
     */
    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
