package javatechy.codegen.service;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import javatechy.codegen.dto.TicketDto;

public interface RequestMakerService {
    MultipartEntityBuilder generateCreateTicketRequestBody(TicketDto ticket);
}
