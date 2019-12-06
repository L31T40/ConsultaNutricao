package com.es2.Armazenamento;

public class StringVaziaExcepcao extends Throwable {
    public StringVaziaExcepcao(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
