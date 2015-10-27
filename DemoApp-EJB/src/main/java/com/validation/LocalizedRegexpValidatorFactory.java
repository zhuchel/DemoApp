package com.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorFactory;
import javax.validation.ValidationException;

public class LocalizedRegexpValidatorFactory implements
		ConstraintValidatorFactory {

	public String objectname = this.getClass().getSimpleName();

	@Override
	public <T extends ConstraintValidator<?, ?>> T getInstance(Class<T> key) {
		try {
			T instance = key.newInstance();
			if (instance instanceof LocalizedRegexpValidator) {
				LocalizedRegexpValidator validator = (LocalizedRegexpValidator) instance;
				validator.setObjectname(objectname);
			}
			return instance;
		} catch (IllegalAccessException ex) {
			throw new ValidationException("Unable to instantiate : "
					+ key.getName(), ex);
		} catch (InstantiationException e) {
		    throw new ValidationException("Unable to instantiate : "
                    + key.getName(), e);
        }
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	@Override
	public void releaseInstance(ConstraintValidator<?, ?> arg0) {
		// TODO Auto-generated method stub
		
	}
}
