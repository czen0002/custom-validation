package io.czen.customvalidation.util;

import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
@Documented
public @interface MobileNumberAndEmailAddressNotBothBlank {

    String message() default "Either Mobile Number or Email Address is required for customer";

    String mobileCountryCode();

    String mobileNumber();

    String emailAddress();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
