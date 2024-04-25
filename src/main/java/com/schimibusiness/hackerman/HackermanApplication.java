package com.schimibusiness.hackerman;

import com.schimibusiness.hackerman.services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class HackermanApplication implements CommandLineRunner {

	private final MainService mainService;

	@Autowired
	public HackermanApplication(MainService mainService) {
		this.mainService = mainService;
	}

	public static void main(String[] args) {
		SpringApplication.run(HackermanApplication.class, args);
	}

	@Override
	public void run(String... args) throws IOException {
		String path = "Personal_files/CV_2024_02_final.pdf";
		String name = "cv";

		mainService.fileUploader(path, name);
	}
}
