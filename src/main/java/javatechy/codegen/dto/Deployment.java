
package javatechy.codegen.dto;

import java.util.HashMap;
import java.util.Map;

public class Deployment {

    private Boolean isDockerEnabled;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getIsDockerEnabled() {
        return isDockerEnabled;
    }

    public void setIsDockerEnabled(Boolean isDockerEnabled) {
        this.isDockerEnabled = isDockerEnabled;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
