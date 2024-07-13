package com.giftOrchids.giftOrchids.service;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.InstanceProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
public class S3Service {

    private final AmazonS3 s3Client;

    @Value("${aws.s3.bucket}")
    private String bucketName;

    public S3Service(@Value("${aws.region}") String region) {
        ClientConfiguration clientConfig = new ClientConfiguration();
        clientConfig.setConnectionTimeout(5000);
        clientConfig.setRequestTimeout(5000);

        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new InstanceProfileCredentialsProvider(false))
                .withClientConfiguration(clientConfig)
                .build();
    }

    public String uploadFile(MultipartFile file) throws IOException {
        String key = UUID.randomUUID() + "-" + file.getOriginalFilename();
        File tempFile = convertMultipartFileToFile(file);
        s3Client.putObject(new PutObjectRequest(bucketName, key, tempFile).withCannedAcl(CannedAccessControlList.PublicRead));
        tempFile.delete();
        return key;
    }

    public URL getFileUrl(String key) {
        return s3Client.getUrl(bucketName, key);
    }

    private File convertMultipartFileToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
