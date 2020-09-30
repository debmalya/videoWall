package com.example.javafx.component;

import javafx.application.HostServices;
import javafx.fxml.FXML;
import org.springframework.stereotype.Component;

@Component
public class SimpleUiController {



    private final HostServices hostServices;





    public SimpleUiController(HostServices hostServices) {

        this.hostServices = hostServices;

    }

    @FXML
    public void initialize(){
//        this.button.setOnAction(actionEvent -> this.label.setText(this.hostServices.getDocumentBase()));
    }
}
