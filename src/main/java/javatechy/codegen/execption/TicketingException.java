package javatechy.codegen.execption;

import org.apache.log4j.Logger;

public class TicketingException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    public static Logger logger = Logger.getLogger(TicketingException.class);

    public TicketingException(String code) {
        super(code);
        logger.error("Execption occured due to code : " + code, this);
    }

}
