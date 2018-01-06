package javatechy.codegen.service.impl;

import java.util.Objects;

import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.stereotype.Service;

import javatechy.codegen.dto.TicketDto;
import javatechy.codegen.service.RequestMakerService;

@Service
public class RequestMakerServiceImpl implements RequestMakerService {

    @Override
    public MultipartEntityBuilder generateCreateTicketRequestBody(TicketDto ticket) {
        MultipartEntityBuilder meb = MultipartEntityBuilder.create();
        meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        meb.addTextBody("email", ticket.getEmail());
        meb.addTextBody("subject", ticket.getSubject());
        meb.addTextBody("description", ticket.getDescription());
        meb.addTextBody("status", String.valueOf(ticket.getStatus()));
        meb.addTextBody("priority", String.valueOf(ticket.getPriority()));
        if (Objects.nonNull(ticket.getType()))
            meb.addTextBody("type", ticket.getType());
        if (Objects.nonNull(ticket.getGroupId()))
            meb.addTextBody("group_id", ticket.getGroupId());
        if (Objects.nonNull(ticket.getInputStream())) {
            meb.addBinaryBody("attachments[]", ticket.getInputStream(), ContentType.TEXT_PLAIN.withCharset("utf-8"), ticket.getFileName());
        }
        return meb;
    }
}
