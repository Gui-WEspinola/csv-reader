package io.github.guiwespinola.productcsv.shared;

import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import io.github.guiwespinola.productcsv.enums.ErrorCode;
import io.github.guiwespinola.productcsv.exception.InvalidCSVException;
import io.github.guiwespinola.productcsv.exception.ResourceNotFoundException;
import io.github.guiwespinola.productcsv.shared.dto.ApiErrors;
import org.apache.tomcat.util.http.fileupload.impl.FileSizeLimitExceededException;
import org.apache.tomcat.util.http.fileupload.impl.SizeLimitExceededException;
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
        ApiErrors apiErrors = ApiErrors.builder()
                .errorCode(ErrorCode.EC1101)
                .httpStatus(ErrorCode.EC1101.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now().withNano(0))
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }

    @ExceptionHandler(InvalidCSVException.class)
    public ResponseEntity<ApiErrors> InvalidCSVExceptionHandler (InvalidCSVException e,
                                                                 HttpServletRequest request) {

        ApiErrors apiErrors = ApiErrors.builder()
                .errorCode(ErrorCode.EC1101)
                .httpStatus(ErrorCode.EC1101.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }

    @ExceptionHandler(SizeLimitExceededException.class)
    public ResponseEntity<ApiErrors> sizeLimitExceededExceptionHandler (SizeLimitExceededException e,
                                                                        HttpServletRequest request) {

        ApiErrors apiErrors = ApiErrors.builder()
                .errorCode(ErrorCode.EC1102)
                .httpStatus(ErrorCode.EC1102.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }
    @ExceptionHandler(FileSizeLimitExceededException.class)
    public ResponseEntity<ApiErrors> fileSizeLimitExceededExceptionHandler (FileSizeLimitExceededException e,
                                                                            HttpServletRequest request) {

        ApiErrors apiErrors = ApiErrors.builder()
                .errorCode(ErrorCode.EC1102)
                .httpStatus(ErrorCode.EC1102.getHttpStatus())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now())
                .path(request.getRequestURI())
                .build();

        return ResponseEntity.status(apiErrors.getHttpStatus()).body(apiErrors);
    }
}
