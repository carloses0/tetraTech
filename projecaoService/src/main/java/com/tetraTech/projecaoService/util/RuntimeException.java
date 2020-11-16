package com.tetraTech.projecaoService.util;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class RuntimeException extends java.lang.RuntimeException {
    public RuntimeException(String mensagem) {
        super(mensagem);
    }
}
