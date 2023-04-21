package br.com.liviasilvasantos.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class FileListenerException extends Exception{

    public FileListenerException(String message) {
        super(message);
    }

    public FileListenerException(Throwable cause) {
        super(cause);
    }

    public FileListenerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileListenerException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
