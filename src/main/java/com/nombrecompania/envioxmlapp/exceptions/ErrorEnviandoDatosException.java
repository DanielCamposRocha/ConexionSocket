package com.nombrecompania.envioxmlapp.exceptions;

import java.io.IOException;

public class ErrorEnviandoDatosException extends IOException {
    public ErrorEnviandoDatosException(IOException e) {
        super(e);
    }
}
