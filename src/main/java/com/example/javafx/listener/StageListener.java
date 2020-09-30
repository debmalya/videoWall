package com.example.javafx.listener;

import com.example.javafx.component.VLCGrid;
import com.example.javafx.constants.VideoWallConstants;
import com.example.javafx.event.StageReadyEvent;
import com.example.javafx.service.URLProviderService;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class StageListener implements ApplicationListener<StageReadyEvent> {
    private final String applicationTitle;
    private final Resource fxml;
    private final ApplicationContext applicationContext;
    private VLCGrid vlcGrid;
    private final int height;
    private final int width;


    private final URLProviderService urlProviderService;

    public StageListener(@Value("${spring.application.ui.title}") String applicationTitle,
                         @Value("classpath:/ui.fxml") Resource fxml,
                         ApplicationContext applicationContext,
                         VLCGrid vlcGrid,
                         @Value("${videowall.height:400}") int height,
                         @Value("${videowall.width:300}") int width, URLProviderService urlProviderService) {
        this.applicationTitle = applicationTitle;
        this.fxml = fxml;
        this.applicationContext = applicationContext;
        this.vlcGrid = vlcGrid;
        this.height = height;
        this.width = width;
        this.urlProviderService = urlProviderService;

    }

    @Override
    public void onApplicationEvent(StageReadyEvent stageReadyEvent) {
        Stage stage = stageReadyEvent.getStage();
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: black;");
        root.setCenter(addFlowPane());
        Scene scene = new Scene(root, width, height, Color.BLACK);
        stage.setTitle(applicationTitle);
        stage.setScene(scene);
        stage.show();

    }

    public FlowPane addFlowPane() {
        FlowPane flow = new FlowPane();
        flow.setPadding(new Insets(5, 0, 5, 0));
        flow.setVgap(0);
        flow.setHgap(0);
        flow.setPrefWrapLength(170); // preferred width allows for two columns
        flow.setStyle("-fx-background-color: DAE6F3;");

        ImageView pages[] = new ImageView[8];
        for (int i = 0; i < VideoWallConstants.NO_OF_VIDEOS; i++) {
            pages[i] = vlcGrid.getVlcComponents()[i].getVideoImageView();
            vlcGrid.getVlcComponents()[i].getEmbeddedMediaPlayer().media().play(urlProviderService.getUrls().get(i));
            pages[i].setFitWidth(width / 2);
            pages[i].setFitHeight(height / 4);
            flow.getChildren().add(pages[i]);
        }

        return flow;
    }
}
