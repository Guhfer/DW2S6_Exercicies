package com.br.ifsp.dw2.taskmanager.controller.advice;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StandardError {

    private String timestamp;
    private Integer status;
    private String errorTitle;
    private String message;
    private String path;
    private List<String> errors;

    public StandardError() {
    }

    public StandardError(String timestamp, Integer status, String errorTitle, String message, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.errorTitle = errorTitle;
        this.message = message;
        this.path = path;
    }

    public StandardError(String timestamp, Integer status, String errorTitle, String path, List<String> errors) {
        this.timestamp = timestamp;
        this.status = status;
        this.errorTitle = errorTitle;
        this.path = path;
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorTitle() {
        return errorTitle;
    }

    public void setErrorTitle(String errorTitle) {
        this.errorTitle = errorTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
