
package javatechy.codegen.dto;

import java.util.HashMap;
import java.util.Map;

public class Controller {

    private String name;
    private String docsComment;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocsComment() {
        return docsComment;
    }

    public void setDocsComment(String docsComment) {
        this.docsComment = docsComment;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
