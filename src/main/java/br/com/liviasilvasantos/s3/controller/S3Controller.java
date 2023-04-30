package br.com.liviasilvasantos.s3.controller;

import br.com.liviasilvasantos.s3.controller.domain.output.S3FileOutput;
import br.com.liviasilvasantos.s3.service.S3FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class S3Controller {

    private static final String FILE_NOT_EXISTS = "Arquivo não existe";

    private final S3FileService fileService;

    @PostMapping("/s3/files")
    public ResponseEntity<S3FileOutput> createFile() {
        Path tempFile;
        try {
            tempFile = Files.createTempFile("prefixo-", ".txt");
            Files.writeString(tempFile, "Conteúdo do Arquivo: " + UUID.randomUUID() + "",
                    StandardCharsets.ISO_8859_1, StandardOpenOption.APPEND);

            fileService.saveFile(Files.newInputStream(tempFile), tempFile.toFile().getName());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(S3FileOutput.of(ex.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(S3FileOutput.of(tempFile.toFile().getName(), null));
    }

    @GetMapping("/s3/files")
    public ResponseEntity<List<S3FileOutput>> listFiles(@RequestParam("fileName") String fileName) {
        List<S3FileOutput> s3Files = new ArrayList<>();
        try {
            List<Resource> resources = fileService.searchFile(fileName, false);

            if (resources.isEmpty()) {
                s3Files.add(S3FileOutput.of(FILE_NOT_EXISTS, null));
                return new ResponseEntity<>(s3Files, HttpStatus.NOT_FOUND);
            }

            for (Resource resource : resources)
                s3Files.add(S3FileOutput.of(resource.getFilename(), null));
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return new ResponseEntity<>(s3Files, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return ResponseEntity.ok(s3Files);
    }

    @GetMapping("/s3/files/{file}")
    public ResponseEntity<S3FileOutput> contentFile(@PathVariable("file") String file) {
        if (fileService.isFileExists(file)) {
            List<Resource> resources = fileService.searchFile(file, true);
            Resource resource = resources.get(0);
            return ResponseEntity.ok(S3FileOutput.of(resource.getFilename(), fileService.contentFile(resource.getFilename())));
        } else {
            return new ResponseEntity<>(S3FileOutput.of(FILE_NOT_EXISTS, null), HttpStatus.NOT_FOUND);
        }
    }
}
