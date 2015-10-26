package com.validation;

public class MessageKeyBuilderUtil {

    public static String buildValidationMessageKey(String severity, String objectname, String attributename,
            String validator) {
        StringBuilder builder = new StringBuilder(severity);
        builder.append(".");
        builder.append(objectname);
        builder.append(".");
        builder.append(attributename);
        builder.append(".");
        builder.append(validator);

        return builder.toString();
    }

}
