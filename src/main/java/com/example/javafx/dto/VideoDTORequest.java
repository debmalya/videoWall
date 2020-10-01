package com.example.javafx.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VideoDTORequest {
    @NonNull
    private String url;
    private String title;
    
    private int videoIndex;
    private String caption;
}
