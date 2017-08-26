package com.boristolstukha.dictionary.server.api.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundHttpException extends Exception{

    public NotFoundHttpException() {
    }

    public NotFoundHttpException(String message) {
        super(message);
    }

    public NotFoundHttpException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundHttpException(Throwable cause) {
        super(cause);
    }

    public NotFoundHttpException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
