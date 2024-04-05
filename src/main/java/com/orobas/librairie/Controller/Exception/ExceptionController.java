package com.orobas.librairie.Controller.Exception;

import com.orobas.librairie.Exception.NotFoundException;
import com.orobas.librairie.Exception.NotImplementedException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.method.ParameterValidationResult;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ExceptionMessage notFound(HttpServletRequest request, Exception exception) {
        return new ExceptionMessage(LocalDateTime.now(), request.getRequestURI(), exception.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ExceptionMessage notFound(HttpServletRequest request, NotFoundException exception) {
        return new ExceptionMessage(LocalDateTime.now(), request.getRequestURI(), exception.getMessage());
    }

    @ExceptionHandler(NotImplementedException.class)
    public ExceptionMessage notImplemented(HttpServletRequest request, NotImplementedException exception) {
        return new ExceptionMessage(LocalDateTime.now(), request.getRequestURI(), exception.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return ResponseEntity.badRequest().body(new ExceptionMessage(LocalDateTime.now(), request.getContextPath(), "Données manquantes", List.of(ex.getParameterName())));
    }

    @Override
    protected ResponseEntity<Object> handleHandlerMethodValidationException(HandlerMethodValidationException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> fieldsError = ex.getAllValidationResults().stream().map(ParameterValidationResult::getResolvableErrors).flatMap(List::stream).map(MessageSourceResolvable::getDefaultMessage).toList();
        return ResponseEntity.badRequest().body(new ExceptionMessage(LocalDateTime.now(), request.getContextPath(), "Données invalides", fieldsError));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail body = this.createProblemDetail(ex, status, "Failed to read request", (String)null, (Object[])null, request);
        List<String> details = new ArrayList<>();
        for (Map.Entry<String, Object> entry : body.getProperties().entrySet()) {
            details.add(entry.getKey() + "=" + entry.getValue());
        }
        return ResponseEntity.badRequest().body(new ExceptionMessage(LocalDateTime.now(), request.getContextPath(), "Données invalides", details));
    }
}
