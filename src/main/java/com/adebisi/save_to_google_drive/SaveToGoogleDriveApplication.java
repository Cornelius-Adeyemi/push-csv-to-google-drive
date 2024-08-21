package com.adebisi.save_to_google_drive;

import com.adebisi.save_to_google_drive.read_file_implementation.GoogleDriveService;
import com.adebisi.save_to_google_drive.read_file_implementation.ReadFile;
import com.adebisi.save_to_google_drive.read_file_implementation.SchedulerImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.File;
import java.util.List;

@SpringBootApplication
@Slf4j
@EnableScheduling
@EnableAsync
@RequiredArgsConstructor
public class SaveToGoogleDriveApplication implements CommandLineRunner {

	private final SchedulerImpl scheduler;

	public static void main(String[] args) {
		SpringApplication.run(SaveToGoogleDriveApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		File file = new File("/Users/adebisiadeyemi/IdeaProjects/save_to_google_drive/report/extracted-Infor-Sheet1.csv");
		GoogleDriveService g= new GoogleDriveService();

		g.uploadFile(file,"text/csv", "");

         //scheduler.sendCsvTofile();

	}
}
