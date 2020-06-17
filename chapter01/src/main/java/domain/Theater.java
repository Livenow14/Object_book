package domain;

import domain.Audience;

public class Theater {
    private TicketSeller ticketSeller;

    /**
     * 여기서 캡슐화가 이루어 진다.
     * Theater클래스 어디에서도 ticketOffice에 접근하지 않는다.
     * Theater는 단지 ticketSeller가 selTo 메세지를 이해하고 응답할 수 있다는 사실만 알고 있을 뿐이다.
     */
    public Theater(TicketSeller ticketSeller){
        this.ticketSeller = ticketSeller;
    }

    public void enter(Audience audience){
        ticketSeller.selTo(audience);
    }
}
