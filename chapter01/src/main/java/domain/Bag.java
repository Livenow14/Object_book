package domain;
import domain.Invitation;
import domain.Ticket;

/**
 * Bag의 내부 상태에 접근하는 모든 로직을 Bag 안으로 캡슐화해서 결합도를 낮췄다.
 * 즉, 상태와 행위도를 함께 가지고 응집도가 높아졌다.
 */
public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;


    public Bag(Long amount){
        this(null,amount);
    }

    public Bag(Invitation invitation, long amount){
        this.invitation=invitation;
        this.amount=amount;
    }


    private boolean hasInvitation(){
        return invitation != null;
    }

    public boolean hasTicket() {
        return ticket != null;
    }

    private void setTicket(Ticket ticket){
        this.ticket=ticket;
    }

    private void minusAmount(Long amount){
        this.amount-= amount;
    }
    public void plusAmount(Long amount){
        this.amount+=amount;
    }

    public Long hold(Ticket ticket){
        if(hasInvitation()){
            setTicket(ticket);
            return 0L;
        }
        else{
            setTicket(ticket);
            minusAmount(ticket.getFee());
            return ticket.getFee();
        }
    }


}
