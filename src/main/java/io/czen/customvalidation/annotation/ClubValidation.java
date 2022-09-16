package io.czen.customvalidation.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.Documented;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
@Documented
@Constraint(validatedBy = ClubValidator.class)
public @interface ClubValidation {

    String message() default "Invalid Club: must be RED, SLIVER and GOLD";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
