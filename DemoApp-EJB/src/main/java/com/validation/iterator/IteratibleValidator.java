package com.validation.iterator;

import com.validation.IValidation;
import com.validation.ViolationMessages;


public interface IteratibleValidator {

	ViolationMessages validate(IValidation bom);
}
