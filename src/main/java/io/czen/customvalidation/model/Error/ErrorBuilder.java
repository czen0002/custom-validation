package io.czen.customvalidation.model.Error;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static java.lang.String.valueOf;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ErrorBuilder {

    private static final String API_BAD_REQUEST = "BAD_REQUEST";

    private ErrorBuilder() {}

    public static Error buildBasicError(String code, String title, String detail) {
        return new Error().code(code).title(title).detail(detail);
    }

    public static Error buildBadRequestError(String detail) {
        return buildBasicError(valueOf(BAD_REQUEST.value()), API_BAD_REQUEST, detail);
    }

    public static Errors buildMethodArgumentNotValidErrors(MethodArgumentNotValidException e) {
        return new Errors().errorList(e.getBindingResult()
                .getAllErrors()
                .stream()
                .map(ErrorBuilder::fromObjectError)
                .toList());
    }

    private static Error fromObjectError(ObjectError objectError) {
        return buildBadRequestError(objectError.getDefaultMessage());
    }
}
