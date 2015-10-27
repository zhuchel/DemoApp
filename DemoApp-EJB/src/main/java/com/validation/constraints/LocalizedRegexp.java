package com.validation.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import com.validation.LocalizedRegexpValidator;
import com.validation.bom.Day;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD })
@Constraint(validatedBy = LocalizedRegexpValidator.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface LocalizedRegexp {

	Day day() default Day.FRIDAY;

	String localeLanguage() default "de";

	String localeCountry() default "DE";

	String objectname() default "Object";

	String severity() default "error";

	String message() default "Invalid field";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
