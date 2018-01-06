package javatechy.codegen.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.http.entity.mime.MultipartEntityBuilder;

import javatechy.codegen.dto.FreshDeskResponse;
import javatechy.codegen.dto.TicketDto;

public interface FreshDeskIntegrationService {
    FreshDeskResponse getRequest(String uri) throws IOException, URISyntaxException;

    FreshDeskResponse postRequest(TicketDto ticket, String uri, MultipartEntityBuilder multipartEntityBuilder) throws IOException, URISyntaxException;

    FreshDeskResponse putRequest(TicketDto ticket, String uri, MultipartEntityBuilder multipartEntityBuilder) throws IOException, URISyntaxException;

    FreshDeskResponse deleteRequest(String uri) throws IOException, URISyntaxException;

}
