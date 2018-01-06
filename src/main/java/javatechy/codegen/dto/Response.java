package javatechy.codegen.dto;

public class Response {

    private String status;
    private String code;
    private String error;

    public Response(String failure) {
        // TODO Auto-generated constructor stub
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
