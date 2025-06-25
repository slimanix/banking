package com.skypay.banking.dto;

import java.util.List;

public class ReponseStatementDTO {
    private List<String> lines;
    public ReponseStatementDTO(List<String> lines) { this.lines = lines; }
    public List<String> getLines() { return lines; }
    public void setLines(List<String> lines) { this.lines = lines; }
} 