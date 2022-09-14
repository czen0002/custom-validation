package io.czen.customvalidation.entity;

import io.czen.customvalidation.util.Club;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MOBILE_COUNTRY_CODE")
    private String mobileCountryCode;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "CLUB")
    @Enumerated(EnumType.STRING)
    private Club club;

}
