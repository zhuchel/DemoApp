package com.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class AbstractRestValidator {

	// public for testing
	public ViolationMessages validate(IValidation bom, Class<?>... clazz) {

		ViolationMessages messages = null;
		Validator validator = ValidationUtils.initializeValidator(bom
				.getClass().getSimpleName());
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
	protected ViolationMessages validate(IValidation bom, String objectname,
			Class<?>... clazz) {

		ViolationMessages messages = null;
		Validator validator = ValidationUtils.initializeValidator(objectname);
		Set<ConstraintViolation<IValidation>> failed = null;
		if (clazz.length > 0) {
			failed = validator.validate(bom, clazz);
		} else {
			failed = validator.validate(bom);
		}
		List<ViolationMessage> list = new ArrayList<ViolationMessage>();
		if (failed != null && failed.size() > 0) {

			for (ConstraintViolation<IValidation> violation : failed) {
				list.add(ValidationUtils.buildViolationMessage(violation,
						objectname));
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

}
