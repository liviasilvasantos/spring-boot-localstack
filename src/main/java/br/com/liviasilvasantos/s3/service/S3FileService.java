package br.com.liviasilvasantos.s3.service;

import com.amazonaws.services.s3.AmazonS3;
import io.awspring.cloud.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class S3FileService {

    @Value("helloworld")
    private String directory;

    @Autowired
    private ResourceLoader resourceLoader;

    private ResourcePatternResolver resourcePatternResolver;

    @Autowired
    public void setupResolver(final ApplicationContext applicationContext, final AmazonS3 amazonS3){
        this.resourcePatternResolver = new PathMatchingSimpleStorageResourcePatternResolver(amazonS3, applicationContext);
    }

    public boolean isFileExists(final String file){
        try {
            final Resource resource = this.resourceLoader.getResource("s3://%s/%s".formatted(this.directory, file));
            return resource.exists();
        } catch (final Exception ex) {
            log.error(ex.getMessage(), ex);
            return false;
        }
    }
}
