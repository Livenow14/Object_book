public class TicketSeller {
    private TicketOffice ticketOffice;

    public TicketSeller(TicketOffice ticketOffice){
        this.ticketOffice=ticketOffice;
    }

    public void selTo(Audience audience){
        ticketOffice.selTicketTo(audience);
    }
}
