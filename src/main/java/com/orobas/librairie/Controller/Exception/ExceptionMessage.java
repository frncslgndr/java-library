package com.orobas.librairie.Controller.Exception;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionMessage {
    private LocalDateTime date;
    private String request;
    private String message;
    private List<String> details;

    public ExceptionMessage(LocalDateTime date, String request, String message) {
        this.date = date;
        this.request = request;
        this.message = message;
    }

    public ExceptionMessage(LocalDateTime date, String request, String message, List<String> details) {
        this.date = date;
        this.request = request;
        this.message = message;
        this.details = details;
    }

}