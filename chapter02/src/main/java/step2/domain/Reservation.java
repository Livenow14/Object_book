package step2.domain;

/**
 * 영화를 예매하기 위해 Screening, Movie, Reservation 인스턴스들은 서로의 메서드를 호출하며 상효 작용한다. 이를 협력이라 부른다.
 */
public class Reservation {      //예매 정보
    private Customer customer;      //예매자 정보
    private Screening Screening;        //상영 정보
    private Money fee;      //예매 정보
    private int audienceCount;      //인원 수

    public Reservation(Customer customer, Screening Screening, Money fee, int audienceCount) {
        this.customer = customer;
        this.Screening = Screening;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }
}
