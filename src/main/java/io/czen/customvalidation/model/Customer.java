package io.czen.customvalidation.model;

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

    @NotBlank(message = "{customer.firstname.NotBlank}")
    private String firstName;

    @NotBlank(message = "{customer.lastname.NotBlank}")
    private String lastName;

    @Size(max = 5, message = "{customer.mobileCountryCode.length}")
    @Pattern(regexp = "|\\+[0-9]+")
    private String mobileCountryCode;

    @Size(max = 30, message = "{customer.mobileNumber.length}")
    @Pattern(regexp = "|[0-9]+")
    private String mobileNumber;

    @Size(max = 100, message = "{customer.emailAddress.length}")
    @Email(message = "{customer.emailAddress.format}")
    private String emailAddress;

    @ClubValidation
    private String club;
}
