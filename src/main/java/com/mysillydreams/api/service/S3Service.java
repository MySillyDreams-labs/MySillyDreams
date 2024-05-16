//package com.mysillydreams.api.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//import software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider;
//import software.amazon.awssdk.core.ResponseBytes;
//import software.amazon.awssdk.core.sync.RequestBody;
//import software.amazon.awssdk.regions.Region;
//import software.amazon.awssdk.services.s3.S3Client;
//import software.amazon.awssdk.services.s3.model.GetObjectRequest;
//import software.amazon.awssdk.services.s3.model.PutObjectRequest;
//import software.amazon.awssdk.services.s3.model.S3Exception;
//
//
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.IOException;
//@Service
//public class S3Service {
//
////    private final AmazonS3 s3Client;
//
//    private final S3Client s3Client;
//    private final String bucketName = "msduserfiles";
//
//    public S3Service() {
//        this.s3Client = S3Client.builder()
//                .region(Region.of("ap-south-2"))
//                .credentialsProvider(InstanceProfileCredentialsProvider.builder().build())
//                .build();
//    }
//
//    public void uploadFile(MultipartFile file) throws IOException {
//        File convertedFile = convertMultiPartFileToFile(file);
//        s3Client.putObject(PutObjectRequest.builder()
//                        .bucket(bucketName)
//                        .key(file.getOriginalFilename())
//                        .build(),
//                RequestBody.fromFile(convertedFile));
//    }
//
//    public byte[] downloadFile(String key) throws IOException {
//        try {
//            ResponseBytes responseBytes = s3Client.getObjectAsBytes(GetObjectRequest.builder()
//                    .bucket(bucketName)
//                    .key(key)
//                    .build());
//            return responseBytes.asByteArray();
//        } catch (S3Exception e) {
//            throw new IOException("Failed to download file: " + e.awsErrorDetails().errorMessage(), e);
//        }
//    }
//
//    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
//        File convertedFile = new File(file.getOriginalFilename());
//        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
//            fos.write(file.getBytes());
//        } catch (IOException e) {
//            // Handle error while writing to file
//            throw new IOException("Failed to convert multipart file to file: " + e.getMessage(), e);
//        }
//        return convertedFile;
//    }
//
//
////    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
////        File convertedFile = new File(file.getOriginalFilename());
////        FileOutputStream fos = new FileOutputStream(convertedFile);
////        fos.write(file.getBytes());
////        fos.close();
////        return convertedFile;
////    }
//}
