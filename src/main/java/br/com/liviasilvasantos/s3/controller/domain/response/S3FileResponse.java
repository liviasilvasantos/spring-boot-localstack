package br.com.liviasilvasantos.s3.controller.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class S3FileResponse {
    private String fileName;
    private String content;

    public static S3FileResponse of(final String fileName, final String content) {
        return S3FileResponse.builder().fileName(fileName).content(content).build();
    }
}
