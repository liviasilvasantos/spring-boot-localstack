package br.com.liviasilvasantos.s3.controller;

import br.com.liviasilvasantos.s3.service.S3FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class S3Controller {

    private static final String FILE_NOT_EXISTS = "Arquivo não existe";

    private final S3FileService fileService;

    @GetMapping("/s3/files/{file}")
    public ResponseEntity<String> isFileExists(@PathVariable("file") String file) {
        if (fileService.isFileExists(file)) {
            return ResponseEntity.ok("File %s existis in bucket".formatted(file));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
