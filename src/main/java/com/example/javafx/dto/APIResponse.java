package com.example.javafx.dto;

import lombok.Data;

@Data
public class APIResponse {
    private String status;
    private String errorCode;
    private String errorMessage;
}
