package javatechy.codegen.dto;

public class FreshDeskResponse {
    private int httpStatus;
    private String responseBody;

    public int getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(int httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "FreshDeskResponse [httpStatus=" + httpStatus + ", responseBody=" + responseBody + "]";
    }

}
