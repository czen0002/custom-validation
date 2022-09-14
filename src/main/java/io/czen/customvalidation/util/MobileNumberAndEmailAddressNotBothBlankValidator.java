package io.czen.customvalidation.util;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MobileNumberAndEmailAddressNotBothBlankValidator implements ConstraintValidator<MobileNumberAndEmailAddressNotBothBlank, Object> {

    private String mobileCountryCode;
    private String mobileNumber;
    private String emailAddress;

    @Override
    public void initialize(MobileNumberAndEmailAddressNotBothBlank constraintAnnotation) {
        this.mobileCountryCode = constraintAnnotation.mobileCountryCode();
        this.mobileNumber = constraintAnnotation.mobileNumber();
        this.emailAddress = constraintAnnotation.emailAddress();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String mobileCountryCodeValue = (String) new BeanWrapperImpl(value).getPropertyValue(mobileCountryCode);
        String mobileNumberValue = (String) new BeanWrapperImpl(value).getPropertyValue(mobileNumber);
        String emailAddressValue = (String) new BeanWrapperImpl(value).getPropertyValue(emailAddress);
        if (mobileCountryCodeValue == null) mobileCountryCodeValue = "";
        if (mobileNumberValue == null) mobileNumberValue = "";
        if (emailAddressValue == null) emailAddressValue = "";
        return !(((mobileCountryCodeValue.isBlank()) || (mobileNumberValue.isBlank())) && emailAddressValue.isBlank());
    }
}
