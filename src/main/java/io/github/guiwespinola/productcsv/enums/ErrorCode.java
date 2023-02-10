package io.github.guiwespinola.productcsv.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;
@Getter
@AllArgsConstructor
public enum ErrorCode {

    EC1001(NOT_FOUND, "Resource not found"),
    EC1101(BAD_REQUEST, "Invalid file format");

    private final HttpStatus httpStatus;

    private final String errorMessage;

}
