package com.example.javafx.service;

import java.awt.Color;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.javafx.component.VLCGrid;

import uk.co.caprica.vlcj.player.base.MarqueeApi;
import uk.co.caprica.vlcj.player.base.MarqueePosition;

@Service
public class URLChangerService {

	private final VLCGrid vlcGrid;

	@Autowired
	public URLChangerService(VLCGrid vlcGrid) {
		this.vlcGrid = vlcGrid;
	}

	public void changeURL(int index, String urlToBeSet, String caption) throws Exception {
		if (index > -1 && index < vlcGrid.getVlcComponents().length) {
			vlcGrid.getVlcComponents()[index].getEmbeddedMediaPlayer().media().play(urlToBeSet);
			MarqueeApi marquee = vlcGrid.getVlcComponents()[index].getEmbeddedMediaPlayer().marquee();
			if (!StringUtils.isEmpty(caption)) {
				marquee.setPosition(MarqueePosition.CENTRE);
				marquee.setText(caption);
				marquee.setColour(Color.CYAN);
				marquee.enable(true);
			}
		} else {
			throw new Exception(
					String.format("Please provide a valid index,range[0-%d].", vlcGrid.getVlcComponents().length - 1));
		}
	}
}
