package io.czen.customvalidation.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ClubValidator implements ConstraintValidator<ClubValidation, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        List<String> list = Arrays.asList("RED", "SILVER", "GOLD");
        return list.contains(value);
    }
}
