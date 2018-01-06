package javatechy.codegen;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonObjectToMap {

    Logger logger = Logger.getLogger(JacksonObjectToMap.class);

    @Test
    public void testJacksonToMap() throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"name\":\"mkyong\", \"age\":29}";
        Map<String, Object> map = new HashMap<String, Object>();
        // convert JSON string to Map
        map = mapper.readValue(json, new TypeReference<Map<String, String>>() {
        });
        logger.info(map);
    }

}
