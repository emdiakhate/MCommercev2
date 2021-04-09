package com.ecommerce.ClientUI.controller;

import com.ecommerce.ClientUI.beans.ProductBean;
import com.ecommerce.ClientUI.proxies.MicroserviceProduitProxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ClientController {
    @Autowired
    MicroserviceProduitProxy microserviceProduitProxy;

    @RequestMapping("/")
    public String Accueil(Model model){
        List<ProductBean> produits = microserviceProduitProxy.listProduit();
        model.addAttribute("produits", produits);
        return "Accueil";
    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable Long id, Model model){
        ProductBean produit = microserviceProduitProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }
}
