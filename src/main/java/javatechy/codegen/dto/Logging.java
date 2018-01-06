
package javatechy.codegen.dto;

import java.util.HashMap;
import java.util.Map;

public class Logging {

    private Boolean isEnabledLog;
    private String loggingFile;
    private String rotationSize;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getIsEnabledLog() {
        return isEnabledLog;
    }

    public void setIsEnabledLog(Boolean isEnabledLog) {
        this.isEnabledLog = isEnabledLog;
    }

    public String getLoggingFile() {
        return loggingFile;
    }

    public void setLoggingFile(String loggingFile) {
        this.loggingFile = loggingFile;
    }

    public String getRotationSize() {
        return rotationSize;
    }

    public void setRotationSize(String rotationSize) {
        this.rotationSize = rotationSize;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
