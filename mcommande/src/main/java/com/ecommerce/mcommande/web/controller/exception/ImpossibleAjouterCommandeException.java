package com.ecommerce.mcommande.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ImpossibleAjouterCommandeException extends RuntimeException {

    public ImpossibleAjouterCommandeException(String message){
        super(message);
    }

    public ImpossibleAjouterCommandeException() {

    }
}