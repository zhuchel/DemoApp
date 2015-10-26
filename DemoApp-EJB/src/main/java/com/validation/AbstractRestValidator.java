package com.validation;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class AbstractRestValidator {

    // public for testing
    public ViolationMessages validate(Locale locale, IValidation bom, Class<?>... clazz) {

        ViolationMessages messages = null;
        Validator validator = ValidationUtils.initializeValidator(locale, bom.getClass().getSimpleName());
        Set<ConstraintViolation<IValidation>> failed = null;
        if (clazz.length > 0) {
            failed = validator.validate(bom, clazz);
        } else {
            failed = validator.validate(bom);
        }
        List<ViolationMessage> list = new ArrayList<ViolationMessage>();
        if (failed != null && failed.size() > 0) {

            for (ConstraintViolation<IValidation> violation : failed) {
                list.add(ValidationUtils.buildViolationMessage(violation));
            }
            if (list.size() > 0) {
                messages = initializeViolationMessages();
                messages.getViolationMessage().addAll(list);
            }
        }
        return messages;
    }

    // TODO refactoring
    protected ViolationMessages validate(Locale locale, IValidation bom, String objectname, Class<?>... clazz) {

        ViolationMessages messages = null;
        Validator validator = ValidationUtils.initializeValidator(locale, objectname);
        Set<ConstraintViolation<IValidation>> failed = null;
        if (clazz.length > 0) {
            failed = validator.validate(bom, clazz);
        } else {
            failed = validator.validate(bom);
        }
        List<ViolationMessage> list = new ArrayList<ViolationMessage>();
        if (failed != null && failed.size() > 0) {

            for (ConstraintViolation<IValidation> violation : failed) {
                list.add(ValidationUtils.buildViolationMessage(violation, objectname));
            }
            if (list.size() > 0) {
                messages = initializeViolationMessages();
                messages.getViolationMessage().addAll(list);
            }
        }
        return messages;
    }

    protected Response setNonAcceptedResponse(ViolationMessages messages) {
        return Response.status(Status.NOT_ACCEPTABLE).entity(messages).build();
    }

    protected ViolationMessages initializeViolationMessages() {
        ViolationMessages messages = new ViolationMessages();
        List<ViolationMessage> messagesList = new ArrayList<ViolationMessage>();
        messages.setViolationMessage(messagesList);
        return messages;
    }

    protected String decodePassword(final String password) {
         String pass = null;
        if (password != null) {
            try {
                pass = URLDecoder.decode(password, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                pass = password;
            } catch (IllegalArgumentException t) {
                pass = password;
            }
        }
        return pass;
    }

}
