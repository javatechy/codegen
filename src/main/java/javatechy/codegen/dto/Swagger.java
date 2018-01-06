
package javatechy.codegen.dto;

import java.util.HashMap;
import java.util.Map;

public class Swagger {

    private Boolean isEnabled;
    private String apiDocName;
    private String developerEmailId;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public String getApiDocName() {
        return apiDocName;
    }

    public void setApiDocName(String apiDocName) {
        this.apiDocName = apiDocName;
    }

    public String getDeveloperEmailId() {
        return developerEmailId;
    }

    public void setDeveloperEmailId(String developerEmailId) {
        this.developerEmailId = developerEmailId;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
