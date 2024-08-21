package com.adebisi.save_to_google_drive.read_file_implementation;


import com.fasterxml.jackson.core.JsonFactoryBuilder;


import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.FileContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

public class GoogleDriveService {



    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

    public static Drive getDriveService() throws GeneralSecurityException, IOException, FileNotFoundException {
        // Load credentials JSON
        GoogleCredentials credential = GoogleCredentials.fromStream(new FileInputStream("/Users/adebisiadeyemi/IdeaProjects/save_to_google_drive/credential/bubbly-jigsaw-432309-j2-eec52c5bd6d4.json"))
                .createScoped(Collections.singleton(DriveScopes.DRIVE_FILE));



        // Build the Drive service
        return new Drive.Builder(GoogleNetHttpTransport.newTrustedTransport(), JSON_FACTORY, new HttpCredentialsAdapter(credential))
                .build();
    }

    public void uploadFile(java.io.File filePath, String mimeType, String folderId) throws GeneralSecurityException, IOException {
        Drive service = getDriveService();
        final String id = "18yz6w2k5gqMmkpoddv1eyPk7p1HiCLX6";
        // Set up file metadata
        File fileMetadata = new File();
        fileMetadata.setName("Adebis.csv");
        fileMetadata.setParents(Collections.singletonList(id)); // Folder ID where the file will be uploaded

        FileContent mediaContent = new FileContent(mimeType, filePath);

        // Upload file
        File file = service.files().create(fileMetadata, mediaContent)
                .setFields("id, parents")
                .execute();

        System.out.println("File ID: " + file.getId());
    }
}
