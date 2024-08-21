package com.adebisi.save_to_google_drive.read_file_implementation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReadFile {

    public List<String[]> readCsvFileFromExternalDirectory(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Assuming CSV is comma-separated
                String[] values = line.split(",");
               // System.out.println(Arrays.toString(values));
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the exception according to your need
        }

        return records;
    }

}
