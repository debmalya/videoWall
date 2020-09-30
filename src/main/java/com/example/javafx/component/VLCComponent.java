package com.example.javafx.component;

import com.example.javafx.adapter.VLCJMediaAdapter;
import javafx.scene.image.ImageView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;

import static uk.co.caprica.vlcj.javafx.videosurface.ImageViewVideoSurfaceFactory.videoSurfaceForImageView;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class VLCComponent {
    private final MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();

    private final EmbeddedMediaPlayer embeddedMediaPlayer;
    private ImageView videoImageView;

    @Autowired
    public VLCComponent() {
        this.videoImageView = new ImageView();
        this.videoImageView.setPreserveRatio(true);
        this.embeddedMediaPlayer = this.mediaPlayerFactory.mediaPlayers().newEmbeddedMediaPlayer();
        this.embeddedMediaPlayer.events().addMediaPlayerEventListener(new VLCJMediaAdapter());
        this.embeddedMediaPlayer.videoSurface().set(videoSurfaceForImageView(this.videoImageView));
    }

    public ImageView getVideoImageView(){
        return videoImageView;
    }

    public EmbeddedMediaPlayer getEmbeddedMediaPlayer(){
        return embeddedMediaPlayer;
    }
}
