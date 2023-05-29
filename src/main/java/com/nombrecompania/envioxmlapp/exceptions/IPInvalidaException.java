package com.nombrecompania.envioxmlapp.exceptions;

import java.util.InputMismatchException;

public class IPInvalidaException extends InputMismatchException {
    public IPInvalidaException(String s) {
        super(s);
    }
}
