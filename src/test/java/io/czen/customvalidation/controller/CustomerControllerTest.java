package io.czen.customvalidation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.nio.file.Files;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class CustomerControllerTest {

    private static final String URL = "/customer";
    private static final String BAD_REQUEST = "BAD_REQUEST";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void expectOK_whenValidaCustomer() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(readFileAsString("valid_customer.json")))
                .andExpect(status().isOk());
    }

    @Test
    void expectClubValidationError_whenInvalidClub() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(readFileAsString("invalid_club.json")))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorList[0].title").value(BAD_REQUEST))
                .andExpect(jsonPath("$.errorList[0].code").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.errorList[0].detail").value("Invalid Club: must be RED, SLIVER and GOLD"));
    }

    @Test
    void expectMobileNumberAndEmailAddressNotBothBlankError_whenNonContactProvide() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(readFileAsString("non_contact.json")))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.errorList[0].title").value(BAD_REQUEST))
                .andExpect(jsonPath("$.errorList[0].code").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(jsonPath("$.errorList[0].detail").value("Either Mobile Number or Email Address is required for customer"));
    }

    private String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(new ClassPathResource(fileName).getFile().toPath()));
    }
}
