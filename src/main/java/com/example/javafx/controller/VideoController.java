package com.example.javafx.controller;

import com.example.javafx.dto.APIResponse;
import com.example.javafx.dto.VideoDTORequest;
import com.example.javafx.service.URLChangerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("Modify RTSP video URL and play with JavaFX")
@RequestMapping("api/v1/video")
@Slf4j
@RequiredArgsConstructor
public class VideoController {

   private final URLChangerService urlChangerService;

    @PostMapping("/set")
    public ResponseEntity<APIResponse> setURL(@RequestBody final VideoDTORequest videoChangeRequest){
        if (log.isInfoEnabled()){
            log.info(String.format("Incoming request : %s",videoChangeRequest));
        }
        APIResponse apiResponse = new APIResponse();
        try {
            urlChangerService.changeURL(videoChangeRequest.getVideoIndex(),videoChangeRequest.getUrl());
            apiResponse.setStatus("OK");
            apiResponse.setErrorCode("");
            apiResponse.setErrorMessage("");
        }catch(Exception exc){
            apiResponse.setStatus("KO");
            apiResponse.setErrorCode("");
            apiResponse.setErrorMessage(exc.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }


        return ResponseEntity.ok(apiResponse);
    }
}
