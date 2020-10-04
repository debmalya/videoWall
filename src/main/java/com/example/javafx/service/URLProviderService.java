package com.example.javafx.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Data
@Service
public class URLProviderService {
	private List<String> urls;

	public URLProviderService(@Value("${videowall.urls}") String rtspURL, 
			@Value("${videowall.rows:4}") int rows,
			@Value("${videowall.columns:2}") int cols) {
		String[] rtspURLs = rtspURL.split(",");
		urls = new ArrayList<>(rows * cols);
		int totalCells = rows * cols;
		for (int i = 0; i < totalCells; i++) {
			urls.add(rtspURLs[i % rtspURLs.length]);
		}
	}
}
