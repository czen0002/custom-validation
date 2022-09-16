package io.czen.customvalidation.model;

import io.czen.customvalidation.util.Club;
import io.czen.customvalidation.annotation.ClubValidation;
import io.czen.customvalidation.annotation.MobileNumberAndEmailAddressNotBothBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Email;
import java.io.Serializable;

@MobileNumberAndEmailAddressNotBothBlank(
        mobileCountryCode = "mobileCountryCode",
        mobileNumber = "mobileNumber",
        emailAddress = "emailAddress"
)
@Getter
@Setter
@NoArgsConstructor
public class Customer implements Serializable {

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
    @Email(message = "EmailAddress must be a well-formed email address")
    private String emailAddress;

    @ClubValidation
    private Club club;
}
