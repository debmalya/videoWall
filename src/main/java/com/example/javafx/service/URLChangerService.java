package com.example.javafx.service;

import com.example.javafx.component.VLCGrid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class URLChangerService {

    private final VLCGrid vlcGrid;
    @Autowired
    public URLChangerService(VLCGrid vlcGrid) {
        this.vlcGrid = vlcGrid;
    }

    public void changeURL(int index,String urlToBeSet) throws Exception {
        if (index > -1 && index < vlcGrid.getVlcComponents().length){
            vlcGrid.getVlcComponents()[index].getEmbeddedMediaPlayer().media().play(urlToBeSet);
        }else{
            throw new Exception(String.format("Please provide a valid index,range[0-%d].",vlcGrid.getVlcComponents().length-1));
        }
    }
}
