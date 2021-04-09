package com.ecommerce.ClientUI.exception;

import feign.Response;
import feign.codec.ErrorDecoder;

public class ClientErrorDecoder implements ErrorDecoder {

    @Override
    public Exception decode(String s, Response response) {
        final ErrorDecoder defaultErrorDecoder = new Default();

        if (response.status() == 404)
            throw new ProduitIntrouvable("Produit non trouvé");

        return defaultErrorDecoder.decode(s, response);
    }
}
