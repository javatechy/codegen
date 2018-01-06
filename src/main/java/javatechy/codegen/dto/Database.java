
package javatechy.codegen.dto;

import java.util.HashMap;
import java.util.Map;

public class Database {

    private Boolean isDatabaseEnabled;
    private String databaseType;
    private String userName;
    private String password;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Boolean getIsDatabaseEnabled() {
        return isDatabaseEnabled;
    }

    public void setIsDatabaseEnabled(Boolean isDatabaseEnabled) {
        this.isDatabaseEnabled = isDatabaseEnabled;
    }

    public String getDatabaseType() {
        return databaseType;
    }

    public void setDatabaseType(String databaseType) {
        this.databaseType = databaseType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
