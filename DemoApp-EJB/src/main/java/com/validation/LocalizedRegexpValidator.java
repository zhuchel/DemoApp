package com.validation;

import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.validation.bom.Day;
import com.validation.constraints.LocalizedRegexp;

public class LocalizedRegexpValidator implements
		ConstraintValidator<LocalizedRegexp, Date> {

	private String objectname;
	private Day day;

	@Override
	public void initialize(LocalizedRegexp regexpHandle) {
		objectname = regexpHandle.objectname();
		day = regexpHandle.day();

	}

	@Override
	public boolean isValid(Date dt, ConstraintValidatorContext constraintCtx) {

		boolean isValid = false;

		if (dt != null) {
			isValid = dt.before(new Date());
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
		if (day == Day.MONDAY)
			isValid = false;
		return isValid;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

}