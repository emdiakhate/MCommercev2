package com.ecommerce.mproduit.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvable extends RuntimeException {
    public ProduitIntrouvable(){
        super();
    }
    public ProduitIntrouvable(String message){
        super(message);
    }
}
