package com.ecommerce.mpaiement.web.controller;

import com.ecommerce.mpaiement.model.Paiement;
import com.ecommerce.mpaiement.repository.PaiementRepository;
import com.ecommerce.mpaiement.web.exception.ImpossiblePaiementCommande;
import com.ecommerce.mpaiement.web.exception.PaiementExistantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaiementController {

    @Autowired
    PaiementRepository paiementRepository;

    @GetMapping("/paiements")
    public List<Paiement> list(){
       return paiementRepository.findAll();
    }

    @PostMapping("/paiement")
    public ResponseEntity<Paiement> payerUneCommande(@RequestBody Paiement paiement) {
        Paiement paiementCom = paiementRepository.findByidCommande(paiement.getIdCommande());

        if (paiementCom != null)
            throw new PaiementExistantException("Cette commande est déja payée");

        Paiement paiementNew = paiementRepository.save(paiement);
        if(paiementNew == null)
            throw new ImpossiblePaiementCommande();

        return new ResponseEntity<Paiement> (paiementNew, HttpStatus.CREATED);
    }


}
