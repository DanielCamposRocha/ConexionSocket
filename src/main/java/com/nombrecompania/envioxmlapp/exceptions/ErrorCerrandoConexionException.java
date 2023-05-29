package com.nombrecompania.envioxmlapp.exceptions;

import java.io.IOException;

public class ErrorCerrandoConexionException extends IOException {

    public ErrorCerrandoConexionException(IOException e) {
        super(e);
    }
}
