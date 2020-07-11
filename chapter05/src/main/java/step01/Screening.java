package step01;



import money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie;    //"가격을 계산하라"라는 메세지를 보내기 위해
    private int sequence;       //상영순번
    private LocalDateTime whenScreened;     //상영 시간

    public Reservation reserve(Customer customer, int audienceCount) {
        return new Reservation(customer, this, calculateFee(audienceCount), audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        return movie.calculateMovieFee(this).times(audienceCount);
    }

    public LocalDateTime getWhenScreened() {
        return whenScreened;
    }

    public int getSequence() {
        return sequence;
    }
}
