package com.validation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.apache.bval.jsr303.ApacheValidationProvider;
import org.apache.bval.jsr303.ApacheValidatorFactory;

public class ValidationUtils {

	public static Validator initializeValidator(Locale locale, String objectname) {
		ApacheValidatorFactory validatorFactory = (ApacheValidatorFactory) Validation
				.byProvider(ApacheValidationProvider.class).configure()
				.buildValidatorFactory();

		LocalizedRegexpValidatorFactory localizedFactory = new LocalizedRegexpValidatorFactory();
		localizedFactory.setLocale(locale);
		localizedFactory.setObjectname(objectname);
		validatorFactory.setConstraintValidatorFactory(localizedFactory);
		Validator validator = validatorFactory.getValidator();
		return validator;
	}

	public static ViolationMessages buildValidationMessages(String objectclass,
			String attributename, String attributevalue, String validator) {
		ViolationMessages messages = new ViolationMessages();

		ViolationMessage vmsg = new ViolationMessage();
		vmsg.setSeverity("error");
		vmsg.setObjectname(objectclass);
		vmsg.setAttributename(attributename);
		vmsg.setAttributevalue(attributevalue);
		vmsg.setValidatorkey(validator);
		List<ViolationMessage> msglist = new ArrayList<ViolationMessage>();
		msglist.add(vmsg);
		messages.setViolationMessage(msglist);
		return messages;
	}

	public static ViolationMessage buildViolationMessage(
			ConstraintViolation<?> violation) {

		ViolationMessage vmsg = new ViolationMessage();
		vmsg.setSeverity("error");
		vmsg.setObjectname(violation.getRootBean().getClass().getSimpleName());
		vmsg.setAttributename(violation.getPropertyPath().toString());

		if (violation.getInvalidValue() != null) {
			if (violation.getInvalidValue() instanceof Date) {
				vmsg.setAttributevalue(((Date) violation.getInvalidValue())
						.toString());
			} else {
				vmsg.setAttributevalue(violation.getInvalidValue().toString());
			}
		}
		vmsg.setValidatorkey(violation.getMessage());

		return vmsg;
	}

	public static ViolationMessage buildViolationMessage(
			ConstraintViolation<?> violation, String objectname) {

		ViolationMessage vmsg = new ViolationMessage();
		vmsg.setSeverity("error");
		vmsg.setObjectname(objectname);
		vmsg.setAttributename(violation.getPropertyPath().toString());

		if (violation.getInvalidValue() != null) {
			if (violation.getInvalidValue() instanceof Date) {
				vmsg.setAttributevalue(((Date) violation.getInvalidValue())
						.toString());
			} else {
				vmsg.setAttributevalue(violation.getInvalidValue().toString());
			}
		}
		vmsg.setValidatorkey(violation.getMessage());

		return vmsg;
	}

	public static ViolationMessage buildViolationMessage(
			String rootBeanClassName, String propertyPath,
			String invalidPropertyValue, String validatorKey) {

		ViolationMessage vmsg = new ViolationMessage();
		vmsg.setSeverity("error");
		vmsg.setObjectname(rootBeanClassName);
		vmsg.setAttributename(propertyPath);
		vmsg.setAttributevalue(invalidPropertyValue);
		vmsg.setValidatorkey(validatorKey);

		return vmsg;
	}

	public static boolean isValidEmail(String email) {
		ResourceBundle bundle = ResourceBundle
				.getBundle(LocalizedRegexpValidator.VALIDATOR_BUNDLE_NAME);
		String regexp = bundle.getString("email.regexpvalidator");
		return email.matches(regexp);
	}
}
