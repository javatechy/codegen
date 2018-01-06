
package javatechy.codegen.dto;


public class Properties {

    private String language;
    private String springVerison;
    private Boolean isConstantFile;
    private Boolean isGlobalExceptionEnabled;
    private Boolean isLombokEnabled;
    private Boolean isActuatorEnabled;

    public Boolean getIsActuatorEnabled() {
        return isActuatorEnabled;
    }

    public void setIsActuatorEnabled(Boolean isActuatorEnabled) {
        this.isActuatorEnabled = isActuatorEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getSpringVerison() {
        return springVerison;
    }

    public void setSpringVerison(String springVerison) {
        this.springVerison = springVerison;
    }

    public Boolean getIsConstantFile() {
        return isConstantFile;
    }

    public void setIsConstantFile(Boolean isConstantFile) {
        this.isConstantFile = isConstantFile;
    }

    public Boolean getIsGlobalExceptionEnabled() {
        return isGlobalExceptionEnabled;
    }

    public void setIsGlobalExceptionEnabled(Boolean isGlobalExceptionEnabled) {
        this.isGlobalExceptionEnabled = isGlobalExceptionEnabled;
    }

    public Boolean getIsLombokEnabled() {
        return isLombokEnabled;
    }

    public void setIsLombokEnabled(Boolean isLombokEnabled) {
        this.isLombokEnabled = isLombokEnabled;
    }

}
