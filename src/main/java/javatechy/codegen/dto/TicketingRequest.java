package javatechy.codegen.dto;

public class TicketingRequest {
    private TicketDto ticketDto;
    private Long templateId;

    public TicketDto getTicketDto() {
        return ticketDto;
    }

    public void setTicketDto(TicketDto ticketDto) {
        this.ticketDto = ticketDto;
    }

}
