package com.nombrecompania.envioxmlapp.exceptions;

public class PuertoInvalidoException extends Throwable {
    public PuertoInvalidoException(String el_puerto_no_es_válido) {
        super(el_puerto_no_es_válido);
    }
}
