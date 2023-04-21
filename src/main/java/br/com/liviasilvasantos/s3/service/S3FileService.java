package br.com.liviasilvasantos.s3.service;

import br.com.liviasilvasantos.exception.FileListenerException;
import com.amazonaws.services.s3.AmazonS3;
import io.awspring.cloud.core.io.s3.PathMatchingSimpleStorageResourcePatternResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.WritableResource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Resource> searchFile(String name, boolean exact) {
        Resource[] resources = null;
        try {
            if (exact)
                resources = this.resourcePatternResolver.getResources(String.format("s3://%s/%s", directory, name));
            else
                resources = this.resourcePatternResolver.getResources(String.format("s3://%s/%s*.*", directory, name));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }

        return Arrays.asList(resources).stream().sorted(Comparator.comparing(Resource::getFilename)).collect(Collectors.toList());
    }


    public void saveFile(InputStream from, String to) throws FileListenerException {
        final String s3Path = String.format("s3://%s/%s", directory, to);
        log.info("s3 path = " + s3Path);

        Resource resource = this.resourceLoader.getResource(s3Path);
        WritableResource writableResource = (WritableResource) resource;

        try (OutputStream outputStream = writableResource.getOutputStream()) {
            from.transferTo(outputStream);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new FileListenerException(ex.getMessage(), ex);
        }
    }
}
