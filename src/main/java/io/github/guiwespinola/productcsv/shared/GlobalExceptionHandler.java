package io.github.guiwespinola.productcsv.shared;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.github.guiwespinola.productcsv.enums.ErrorCode;
import io.github.guiwespinola.productcsv.exception.ResourceNotFoundException;
import io.github.guiwespinola.productcsv.shared.dto.ApiErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrors> ResourceNotFoundExceptionExceptionHandler (ResourceNotFoundException e,
                                                                                HttpServletRequest request) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .errorCode(ErrorCode.EC1001)
                .httpStatus(ErrorCode.EC1001.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }

    @ExceptionHandler(CsvRequiredFieldEmptyException.class)
    public ResponseEntity<ApiErrors> CsvRequiredFieldEmptyExceptionHandler (CsvRequiredFieldEmptyException e,
                                                                            HttpServletRequest request) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .errorCode(ErrorCode.EC1101)
                .httpStatus(ErrorCode.EC1101.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiErrors> RuntimeExceptionHandler (RuntimeException e,
                                                                            HttpServletRequest request) {
        ApiErrors apiErrors = ApiErrors
                .builder()
                .errorCode(ErrorCode.EC1101)
                .httpStatus(ErrorCode.EC1101.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }
}
