package br.com.liviasilvasantos.s3.configuration;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


//@Configuration
//@RequiredArgsConstructor
public class S3Configuration {

//    private final AwsConfigProperties awsConfigProperties;
//
//    @Bean
//    public AmazonS3 getAmazonS3Client(final AWSCredentialsProvider awsCredentialsProvider){
//        return AmazonS3ClientBuilder
//                .standard()
//                .withRegion(awsConfigProperties.getRegion())
//                .withEndpointConfiguration(getEndpointConfiguration(awsConfigProperties.getS3Url()))
//                .withCredentials(getCredentials())
//                .build();
//    }
//
//    private AwsClientBuilder.EndpointConfiguration getEndpointConfiguration(String url) {
//        return new AwsClientBuilder.EndpointConfiguration(url, Regions.fromName(awsConfigProperties.getRegion()).getName());
//    }
//
//    private AWSCredentialsProvider getCredentials() {
//        return new AWSStaticCredentialsProvider(
//                new BasicAWSCredentials(awsConfigProperties.getAccessKey(), awsConfigProperties.getSecretAccessKey()));
//    }

}
