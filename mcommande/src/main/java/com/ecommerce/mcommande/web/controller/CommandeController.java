package com.ecommerce.mcommande.web.controller;

import com.ecommerce.mcommande.model.Commande;
import com.ecommerce.mcommande.repository.CommandeRepository;
import com.ecommerce.mcommande.web.controller.exception.CommandeNotFoundException;
import com.ecommerce.mcommande.web.controller.exception.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommandeController {

    @Autowired
    CommandeRepository commandeRepository;

    @GetMapping("/commandes")
    public List<Commande> listCommande(){
            return commandeRepository.findAll();
    }

    @GetMapping("/commandes/{id}")
    public Commande recupererUneCommande(@PathVariable Long id) throws CommandeNotFoundException{
        Commande commandeRecup = commandeRepository.findById(id).orElseThrow(( ()-> new CommandeNotFoundException("Commande inexistant")));
        return commandeRecup;
    }


    @PostMapping("/commandes")
    public ResponseEntity<Commande> ajouterCommande(@RequestBody Commande commande){
        Commande commandeAjoute = commandeRepository.save(commande);
         if(commandeAjoute == null)
             throw new ImpossibleAjouterCommandeException();
         return new ResponseEntity<Commande> (commandeAjoute,HttpStatus.CREATED);
    }


}
