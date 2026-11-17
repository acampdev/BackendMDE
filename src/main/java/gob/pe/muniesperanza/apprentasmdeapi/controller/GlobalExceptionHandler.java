package gob.pe.muniesperanza.apprentasmdeapi.controller;

import gob.pe.muniesperanza.apprentasmdeapi.exception.ApiException;
import gob.pe.muniesperanza.apprentasmdeapi.exception.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.net.URI;

@ControllerAdvice
public class GlobalExceptionHandler {
  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<ProblemDetail> handleApiException(ApiException exception, HttpServletRequest request) {
    return problem(exception.getStatus(), exception.getCode(), exception.getMessage(), request);
  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ProblemDetail> handleNotFound(ResourceNotFoundException exception, HttpServletRequest request) {
    return problem(HttpStatus.NOT_FOUND, "RESOURCE_NOT_FOUND", exception.getMessage(), request);
  }

  @ExceptionHandler(BadCredentialsException.class)
  public ResponseEntity<ProblemDetail> handleBadCredentials(HttpServletRequest request) {
    return problem(HttpStatus.UNAUTHORIZED, "INVALID_CREDENTIALS", "Usuario o contraseña incorrectos", request);
  }

  @ExceptionHandler(MaxUploadSizeExceededException.class)
  public ResponseEntity<ProblemDetail> handleMaxSizeException(MaxUploadSizeExceededException exception,
                                                               HttpServletRequest request) {
    return problem(HttpStatus.PAYLOAD_TOO_LARGE, "UPLOAD_TOO_LARGE",
            "El tamaño del archivo excede el límite permitido", request);
  }

  @ExceptionHandler(DataAccessException.class)
  public ResponseEntity<ProblemDetail> handleDataAccess(DataAccessException exception, HttpServletRequest request) {
    log.error("Database operation failed for {}", request.getRequestURI(), exception);
    return problem(HttpStatus.SERVICE_UNAVAILABLE, "DATABASE_UNAVAILABLE",
            "No se pudo completar la operación de datos", request);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ProblemDetail> handleUnexpected(Exception exception, HttpServletRequest request) {
    log.error("Unexpected error processing {}", request.getRequestURI(), exception);
    return problem(HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_ERROR", "Ocurrió un error interno", request);
  }

  private ResponseEntity<ProblemDetail> problem(HttpStatus status, String code, String detail,
                                                 HttpServletRequest request) {
    ProblemDetail problem = ProblemDetail.forStatusAndDetail(status, detail);
    problem.setTitle(status.getReasonPhrase());
    problem.setInstance(URI.create(request.getRequestURI()));
    problem.setProperty("code", code);
    return ResponseEntity.status(status).body(problem);
  }
}
