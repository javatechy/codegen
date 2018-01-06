package javatechy.codegen.dto;

import java.io.InputStream;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Getter;

/**
 * @author deepak.kumar
 *
 */
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketDto {
    @Getter
    private String subject;
    @Getter
    private String description;
    @Getter
    private String email;
    @Getter
    private String groupId;
    @Getter
    private InputStream inputStream;
    @Getter
    private String fileName;
    @Getter
    private String type;

    @Getter
    @Builder.Default
    private int status = TicketStatus.OPEN;

    @Getter
    @Builder.Default
    private int priority = TicketPriority.MEDIUM;

}
