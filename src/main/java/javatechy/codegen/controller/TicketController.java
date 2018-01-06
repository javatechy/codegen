package javatechy.codegen.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javatechy.codegen.dto.TicketDto;
import javatechy.codegen.dto.TicketingRequest;
import javatechy.codegen.dto.TicketingResponse;
import javatechy.codegen.service.TicketOperationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Ticket Controller")
@CrossOrigin(origins = "*")
@RequestMapping("tickets")
@RestController
public class TicketController {

    @Autowired
    private TicketOperationService ticketOperationService;

    private Logger logger = Logger.getLogger(TicketController.class);

    @ApiOperation(value = "Create a ticket with atachment")
    @PostMapping(value = "{userId}/create/attachment", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketingResponse createTicketWithAttachment(@RequestParam("file") MultipartFile file, @RequestParam("ticketDto") String ticketDto) {
        TicketDto ticketDto = TicketDto.builder()
            .description("Test Description")
            .email("deepak.kumar.iet@gmail.com")
            .build();
        ticketOperationService.createTicket(ticketDto);
        logger.info("[TICKET_CREATE] Recieved request is => " + file.getOriginalFilename() + " userId" + userId);// + "request => " + request);
        return null;
    }

    @ApiOperation(value = "Create a ticket without attachment")
    @PostMapping(value = "{userId}/create/plain", produces = MediaType.APPLICATION_JSON_VALUE)
    public TicketingResponse createTicketWithoutAttachment(@RequestBody TicketingRequest ticketingRequest, @PathVariable String userId) {
        logger.info("[TICKET_CREATE] Recieved request is => " + ticketingRequest + " userId" + ticketingRequest);// + "request => " + request);
        ticketOperationService.createTicket(ticketingRequest.getTicketDto());
        return null;
    }
}
