package io.czen.customvalidation.model;

import io.czen.customvalidation.util.Club;
import io.czen.customvalidation.util.ClubValidation;
import io.czen.customvalidation.util.MobileNumberAndEmailAddressNotBothBlank;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MobileNumberAndEmailAddressNotBothBlank(
        mobileCountryCode = "mobileCountryCode",
        mobileNumber = "mobileNumber",
        emailAddress = "emailAddress"
)
public class Customer {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Size(max = 5, message = "MobileCountryCode length must not be greater than 5")
    @Pattern(regexp = "|\\+[0-9]+")
    private String mobileCountryCode;

    @Size(max = 30, message = "MobileNumber length must not be greater than 30")
    @Pattern(regexp = "|[0-9]+")
    private String mobileNumber;

    @Size(max = 100, message = "EmailAddress length must not be greater than 100")
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*" +
            "@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$",
            message = "EmailAddress must be a well-formed email address")
    private String emailAddress;

    @ClubValidation
    private Club club;
}
