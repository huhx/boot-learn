package com.linux.huhx.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({RuntimeException.class})
  protected ResponseEntity<Object> handleAllRunTimeException(RuntimeException ex,
      WebRequest request) {
    if (ex instanceof BaseRuntimeException) {
      return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST,
          request);
    }
    return handleExceptionInternal(ex, "System error.", new HttpHeaders(), HttpStatus.BAD_REQUEST,
        request);
  }


}
