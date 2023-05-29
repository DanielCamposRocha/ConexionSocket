package com.nombrecompania.envioxmlapp.exceptions;

import java.io.IOException;

public class ErrorDeConexionException extends Throwable {
    public ErrorDeConexionException(IOException s){super(s);}
}
