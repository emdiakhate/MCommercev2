package com.ecommerce.ClientUI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProduitIntrouvable extends RuntimeException {
    public ProduitIntrouvable(String message) {
        super(message);
    }
}
