package io.github.bruno.msavaliadorcredito.handler;

import feign.FeignException;
import io.github.bruno.msavaliadorcredito.exceptions.DataNotFoundException;
import io.github.bruno.msavaliadorcredito.exceptions.ErroSolicitacaoCartaoException;
import io.github.bruno.msavaliadorcredito.exceptions.ErrorMicroserviceException;
import io.github.bruno.msavaliadorcredito.exceptions.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ResponseException> dataNotFound(DataNotFoundException ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseException);
    }

    @ExceptionHandler(FeignException.ServiceUnavailable.class)
    public ResponseEntity<ResponseException> unexpectedException(ErrorMicroserviceException ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(responseException);
    }

    @ExceptionHandler(ErroSolicitacaoCartaoException.class)
    public ResponseEntity<ResponseException> errorRequestingCard(ErroSolicitacaoCartaoException ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseException);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseException> globalExceptionsErrors(Exception ex, WebRequest request) {
        ResponseException responseException = new ResponseException(LocalDateTime.now(), ex.getMessage(),
                request.getDescription(false));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseException);
    }
}
