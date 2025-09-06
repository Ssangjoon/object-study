package org.eternity.theater;

public class Bag {
    private Long amount;
    private Invitation invitation;
    private Ticket ticket;

    public Long hold(Ticket ticket){
        if (hasInvitation()) {
            setTicket(ticket);
            return 0L; // 무료 티켓
        } else {
            minusAmount(ticket.getFee());
            setTicket(ticket);
            return ticket.getFee(); // 유료 티켓
        }
    }

    private boolean hasInvitation() {
        return invitation != null;
    }

    private void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    private void minusAmount(Long amount) {
        this.amount -= amount;
    }

}