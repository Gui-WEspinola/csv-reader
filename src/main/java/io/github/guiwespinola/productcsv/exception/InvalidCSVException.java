package io.github.guiwespinola.productcsv.exception;

import lombok.Getter;

@Getter
public class InvalidCSVException extends RuntimeException {

    public InvalidCSVException(String message) {
        super(message);
    }
}
