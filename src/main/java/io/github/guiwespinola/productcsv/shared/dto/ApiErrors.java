package io.github.guiwespinola.productcsv.shared.dto;

import io.github.guiwespinola.productcsv.enums.ErrorCode;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiErrors {

    private LocalDateTime timestamp;

    private String message;

    private ErrorCode errorCode;

    private HttpStatus httpStatus;

    private String path;


}
