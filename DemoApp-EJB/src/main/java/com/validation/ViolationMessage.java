package com.validation;

public class ViolationMessage {
    private String severity;
    private String objectname;
    private String attributename;
    private String attributevalue;
    private String configvalue;
    private String validatorkey;
    // generic message, if set clients show this message and ignore key
    private String message;

    public String getObjectname() {
        return objectname;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public String getAttributename() {
        return attributename;
    }

    public void setAttributename(String attributename) {
        this.attributename = attributename;
    }

    public String getAttributevalue() {
        return attributevalue;
    }

    public void setAttributevalue(String attributevalue) {
        this.attributevalue = attributevalue;
    }

    public String getValidatorkey() {
        return validatorkey;
    }

    public void setValidatorkey(String validatorkey) {
        this.validatorkey = validatorkey;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue;
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
