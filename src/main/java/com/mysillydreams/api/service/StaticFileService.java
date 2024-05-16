package com.mysillydreams.api.service;

import com.amazonaws.regions.Regions;
import org.springframework.stereotype.Service;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import java.io.File;

@Service
public class StaticFileService {

    private final String bucketName = "msduserfiles";
    private final AmazonS3 s3Client;

    public StaticFileService() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(Regions.AP_SOUTH_2) // Specify the AWS region
                .build();
    }

    public void uploadFileToS3(File file) {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, file.getName(), file);
        s3Client.putObject(putObjectRequest);
    }

}
