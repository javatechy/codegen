package javatechy.codegen.service.impl;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javatechy.codegen.dto.FreshDeskResponse;
import javatechy.codegen.dto.TicketDto;
import javatechy.codegen.service.FreshDeskIntegrationService;
import javatechy.codegen.service.RequestMakerService;
import javatechy.codegen.service.TicketOperationService;

@Service
public class TicketOperationServiceImpl implements TicketOperationService {

    private Logger logger = Logger.getLogger(TicketOperationServiceImpl.class);

    private static final String RESOURCE_AGENTS = "/agents/";
    private static final String RESOURCE_TICKETS = "/tickets/";
    private static final String RESOURCE_CONVERSATION = "/conversations";
    private static final String RESOURCE_ROLES = "/roles/";
    private static final String RESOURCE_CONTACTS = "/contacts/";

    @Autowired
    private FreshDeskIntegrationService freshDeskIntegrationService;

    @Autowired
    private RequestMakerService requestMakerService;

    @Override
    public FreshDeskResponse createTicket(TicketDto ticket) throws IOException, URISyntaxException {
        logger.info("Creating ticket");
        MultipartEntityBuilder meb = requestMakerService.generateCreateTicketRequestBody(ticket);
        return freshDeskIntegrationService.postRequest(ticket, RESOURCE_TICKETS, meb);
    }

    @Override
    public FreshDeskResponse fetchAllTickets() throws IOException, URISyntaxException {
        logger.info("fetching all ticket");
        return freshDeskIntegrationService.getRequest(RESOURCE_TICKETS);
    }

    @Override
    public FreshDeskResponse fetchTicketConverstion(int ticketId) throws IOException, URISyntaxException {
        logger.info("fetching ticket conversation for " + ticketId);
        return freshDeskIntegrationService.getRequest(RESOURCE_TICKETS + ticketId + RESOURCE_CONVERSATION);
    }

    @Override
    public FreshDeskResponse fetchTicketByTicketId(int ticketId) throws IOException, URISyntaxException {
        logger.info("fetching ticket with ticket ID =>" + ticketId);
        return freshDeskIntegrationService.getRequest(RESOURCE_TICKETS + ticketId);
    }

    @Override
    public FreshDeskResponse fetchAgentInfo(int agentId) throws IOException, URISyntaxException {
        logger.info("fetching ticket with agentId =>" + agentId);
        return freshDeskIntegrationService.getRequest(RESOURCE_AGENTS + agentId);
    }

    @Override
    public FreshDeskResponse fetchContactInfo(int agentId) throws IOException, URISyntaxException {
        logger.info("fetching ticket with agentId =>" + agentId);
        return freshDeskIntegrationService.getRequest(RESOURCE_CONTACTS + agentId);
    }

    @Override
    public FreshDeskResponse fetchRolesInfo(int roleId) throws IOException, URISyntaxException {
        logger.info("fetching ticket with roleId ID =>" + roleId);
        return freshDeskIntegrationService.getRequest(RESOURCE_ROLES + roleId);
    }

}
