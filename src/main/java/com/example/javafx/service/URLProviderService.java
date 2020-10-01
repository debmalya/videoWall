package com.example.javafx.service;

import com.example.javafx.constants.VideoWallConstants;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Data
@Service
public class URLProviderService {
    private List<String> urls = new ArrayList<>(VideoWallConstants.NO_OF_VIDEOS);

    public URLProviderService() {
        for (int i = 0; i < VideoWallConstants.NO_OF_VIDEOS; i++) {
            switch (i % 2) {

                case 0:
                    urls.add("rtsp://freja.hiof.no:1935/rtplive/_definst_/hessdalen03.stream");
                    break;

                default:
                    urls.add("rtsp://170.93.143.139/rtplive/470011e600ef003a004ee33696235daa");
                    break;
            }
        }
    }
}
