package javatechy.codegen.dto;

public class TicketingResponse {
    private String status;
    private String code;
    private String error;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public TicketingResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", code=" + code + ", error=" + error + "]";
    }

}
