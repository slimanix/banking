package com.skypay.banking.dto;

public class AnswerDTO {
    private String message;
    public AnswerDTO(String message) { this.message = message; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
} 