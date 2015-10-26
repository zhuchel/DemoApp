package com.validation;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LocalizedRegexpValidator implements ConstraintValidator<LocalizedRegexp, String> {

    private Locale currentLocale;
    private String objectname;
    private String key;
    private String attributename;
    private String severity;

    private static final Logger LOGGER = Logger.getLogger(LocalizedRegexpValidator.class.getCanonicalName());

    private ResourceBundle validatorBundle;
    public final static String VALIDATOR_BUNDLE_NAME = "sdfd";

    @Override
    public void initialize(LocalizedRegexp regexpHandle) {
        key = regexpHandle.key();
        attributename = regexpHandle.attributename();
        currentLocale = new Locale(regexpHandle.localeLanguage(), regexpHandle.localeCountry());
        validatorBundle = ResourceBundle.getBundle(VALIDATOR_BUNDLE_NAME, currentLocale);
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintCtx) {

        boolean isValid = false;
        String regexp = validatorBundle.getString(key);

        if (object != null) {
            isValid = object.matches(regexp);
            if (!isValid) {

                constraintCtx.disableDefaultConstraintViolation();
                constraintCtx.buildConstraintViolationWithTemplate(key).addConstraintViolation();
            }
        }
        // In case of null values dont match. Use @NotNull on the attribute
        // instead
        else
            isValid = true;
        return isValid;
    }

    public void setLocale(Locale locale) {
        this.currentLocale = locale;
    }

    public void setObjectname(String objectname) {
        this.objectname = objectname;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }
}