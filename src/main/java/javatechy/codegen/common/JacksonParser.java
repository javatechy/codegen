package javatechy.codegen.common;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javatechy.codegen.exception.TicketingException;

public class JacksonParser {
    private static Logger logger = Logger.getLogger(JacksonParser.class);

    private static ObjectMapper mapper = new ObjectMapper();

    public static void jacksonObjectToMap(String jsonStr) {
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(jsonStr, new TypeReference<Map<String, String>>() {
            });
        } catch (IOException e) {
            logger.error("Error while converting string to json" + jsonStr, e);
            throw new TicketingException(Constant.EX_UNKOWN_EXCEPTION_CODE);
        }
    }

}
