package com.example.meus_gastos.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensagem){
        super(mensagem);
    }
}
