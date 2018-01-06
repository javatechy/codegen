package javatechy.codegen;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.log4j.Logger;

import javatechy.codegen.dto.FreshDeskResponse;
import javatechy.codegen.dto.TicketDto;
import javatechy.codegen.dto.TicketPriority;
import javatechy.codegen.dto.TicketStatus;
import javatechy.codegen.dto.TicketType;
import javatechy.codegen.service.impl.FreshDeskIntegrationServiceImpl;
import javatechy.codegen.service.impl.RequestMakerServiceImpl;

/**
 * Unit test for freshdesk Service.
 */
public class TicketTest {

    Logger logger = Logger.getLogger(TicketTest.class);

    /**
     * Creating a ticket without attachment Test :-)
     * @throws URISyntaxException 
     * @throws IOException 
     */
   // @Test
    public void testTicketCreationWithoutAttachment() throws IOException, URISyntaxException {
        logger.info("Testing ticket creation without attachment");

        TicketDto ticket = TicketDto.builder()
            .subject("TEST Subject")
            .description("A Test Description")
            .email("deepak.kumar@fabhotels.com")
            .groupId("35000194941")
            .priority(TicketPriority.HIGH)
            .status(TicketStatus.PENDING)
            .type(TicketType.INCIDENT)
            .build();
        FreshDeskIntegrationServiceImpl ticketCreator = new FreshDeskIntegrationServiceImpl();
        RequestMakerServiceImpl request = new RequestMakerServiceImpl();
        FreshDeskResponse statusCode = ticketCreator.postRequest(ticket, "/tickets", request.generateCreateTicketRequestBody(ticket));
        System.out.println("STATUS  CODE returned => " + statusCode);
    }

    //@Test
    public void testFetchTickets() throws IOException, URISyntaxException {
        String uri = "/tickets";
        test(uri);
    }
   // @Test
    public void testTicketConversation() throws IOException, URISyntaxException {
        String uri = "/tickets/31/conversations";
        test(uri);
    }

    private void test(String uri) throws IOException, URISyntaxException {
        FreshDeskIntegrationServiceImpl ticketCreator = new FreshDeskIntegrationServiceImpl();
        FreshDeskResponse statusCode = ticketCreator.getRequest(uri);
        System.out.println("[FTEHC]STATUS  CODE returned => " + statusCode);
    }
}
