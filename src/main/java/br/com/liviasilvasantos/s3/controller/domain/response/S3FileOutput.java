package br.com.liviasilvasantos.s3.controller.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class S3FileOutput {
    private String fileName;
    private String content;

    public static S3FileOutput of(final String fileName, final String content) {
        return S3FileOutput.builder().fileName(fileName).content(content).build();
    }
}
