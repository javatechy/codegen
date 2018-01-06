package javatechy.codegen.service;

import java.io.IOException;
import java.net.URISyntaxException;

import javatechy.codegen.dto.FreshDeskResponse;
import javatechy.codegen.dto.TicketDto;

public interface TicketOperationService {

    FreshDeskResponse createTicket(TicketDto ticket) throws IOException, URISyntaxException;

    FreshDeskResponse fetchAllTickets() throws IOException, URISyntaxException;

    FreshDeskResponse fetchTicketByTicketId(int ticketId) throws IOException, URISyntaxException;

    FreshDeskResponse fetchAgentInfo(int agentId) throws IOException, URISyntaxException;

    FreshDeskResponse fetchRolesInfo(int roleId) throws IOException, URISyntaxException;

    FreshDeskResponse fetchTicketConverstion(int ticketId) throws IOException, URISyntaxException;

    FreshDeskResponse fetchContactInfo(int agentId) throws IOException, URISyntaxException;

}
