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
		String path1 = "Personal_files/CV_2024_02_final.pdf";
		String name1 = "cv.pdf";

		String path2 = "Personal_files/CodeCool_certificate.pdf";
		String name2 = "CodeCool_certificate.pdf";

		String path3 = "Personal_files/GFA_certificate.pdf";
		String name3 = "GFA_certificate.pdf";

		String path4 = "Personal_files/Stanag_3_certificate.pdf";
		String name4 = "Stanag_3_certificate.pdf";

		mainService.fileUploader(path1, name1);
		mainService.fileUploader(path2, name2);
		mainService.fileUploader(path3, name3);
		mainService.fileUploader(path4, name4);


	}
}
