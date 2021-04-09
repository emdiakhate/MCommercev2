package com.ecommerce.mproduit.web.controller;


import com.ecommerce.mproduit.configuration.ApplicationPropertiesConfig;
import com.ecommerce.mproduit.model.Produit;
import com.ecommerce.mproduit.repository.ProduitRepository;
import com.ecommerce.mproduit.web.exception.AjoutProduitImpossiblle;
import com.ecommerce.mproduit.web.exception.ProduitIntrouvable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProduitController implements HealthIndicator {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ApplicationPropertiesConfig applicationPropertiesConfig;

  @GetMapping("/produits")
    public List<Produit> listProduit(){
      List<Produit> listeLimitee = produitRepository.findAll().subList(0, applicationPropertiesConfig.getLimitDeProduit());
        return listeLimitee;
    }

    @GetMapping("/produits/{id}")
    public Produit recupererUnProduit(@PathVariable Long id){
        Produit produitRecup = produitRepository.findById(id).orElseThrow(( ()-> new ProduitIntrouvable("Produit inexistant")));
        return produitRecup;
    }

    @PostMapping("/produits")
    public ResponseEntity<Produit> save(@RequestBody Produit produit){
      Produit produitAjout = produitRepository.save(produit);
        if (produitAjout == null)
            throw new AjoutProduitImpossiblle();
        return new ResponseEntity<Produit>(produitAjout, HttpStatus.CREATED);
    }

    @Override
    public Health health() {
       List<Produit> produits = produitRepository.findAll();
       if (produits.isEmpty())
           return Health.down().build();
       return Health.up().build();
    }
}
