package com.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.validation.constraints.LocalizedRegexpHui;

public class LocalizedRegexpValidatorHui implements
		ConstraintValidator<LocalizedRegexpHui, String> {

	private String objectname;

	@Override
	public void initialize(LocalizedRegexpHui regexpHandle) {
		objectname = regexpHandle.objectname();
	}

	@Override
	public boolean isValid(String dt, ConstraintValidatorContext constraintCtx) {

		boolean isValid = false;

		if (dt != null) {
			// isValid = dt.before(new Date());
			if (!isValid) {

				constraintCtx.disableDefaultConstraintViolation();
				constraintCtx.buildConstraintViolationWithTemplate(objectname)
						.addConstraintViolation();
			}
		}
		// In case of null values dont match. Use @NotNull on the attribute
		// instead
		else {
			isValid = true;
		}
		// if (day == Day.MONDAY)
		// isValid = false;
		return isValid;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

}