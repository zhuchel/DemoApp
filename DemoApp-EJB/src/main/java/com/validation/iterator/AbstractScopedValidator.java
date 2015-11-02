package com.validation.iterator;

import java.util.ArrayList;
import java.util.List;

import com.validation.IValidation;
import com.validation.ViolationMessages;

public class AbstractScopedValidator {

	private List<IteratibleValidator> scopedValidators = new ArrayList<IteratibleValidator>();

	ViolationMessages messages = new ViolationMessages();

	public ViolationMessages validate(IValidation bom) {
		for (IteratibleValidator validator : scopedValidators) {
			messages = validator.validate(bom);
		}
		return messages;
	}

	public void setScopedValidators(List<IteratibleValidator> scopedValidators) {
		this.scopedValidators = scopedValidators;
	}

	public List<IteratibleValidator> getScopedValidators() {
		return scopedValidators;
	}

}
