package br.com.liviasilvasantos.s3.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

//@ConfigurationProperties(prefix = "aws-config")
//@Getter
//@Setter
public class AwsConfigProperties {

    private String region;
    private String accessKey;
    private String secretAccessKey;
    private String s3Url;
    private String s3BucketName;
}
