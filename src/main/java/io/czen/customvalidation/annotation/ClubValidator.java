package io.czen.customvalidation.annotation;

import io.czen.customvalidation.util.Club;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ClubValidator implements ConstraintValidator<ClubValidation, Club> {

    @Override
    public boolean isValid(Club value, ConstraintValidatorContext context) {
        List<Club> list = Arrays.asList(Club.RED, Club.SILVER, Club.GOLD);
        return list.contains(value);
    }
}
