package io.czen.customvalidation.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class ClubValidator implements ConstraintValidator<ClubValidation, Enum<Club>> {

    @Override
    public boolean isValid(Enum<Club> value, ConstraintValidatorContext context) {
        List<Enum<Club>> list = Arrays.asList(Club.RED, Club.SILVER, Club.GOLD);
        return list.contains(value);
    }
}
