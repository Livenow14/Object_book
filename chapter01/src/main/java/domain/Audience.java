package domain;

/**
 * 구현이 아닌 인터페이스에 집중하도록 바꿈.
 */
public class Audience {
    private Bag bag;

    public Audience(Bag bag){
        this.bag=bag;
    }

    public Bag getBag() {
        return bag;
    }

    public Long buy(Ticket ticket){
        return bag.hold(ticket);
    }
}
