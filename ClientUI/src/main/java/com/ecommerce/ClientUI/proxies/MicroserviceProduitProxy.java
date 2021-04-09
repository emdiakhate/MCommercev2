package com.ecommerce.ClientUI.proxies;

import com.ecommerce.ClientUI.beans.ProductBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="zull-server")
@RibbonClient(name = "microservice-produits")
public interface MicroserviceProduitProxy {

    @GetMapping("/microservice-produits/produits")
    List<ProductBean> listProduit();

    @GetMapping("/microservice-produits/produits/{id}")
    ProductBean recupererUnProduit(@PathVariable Long id);

    @PostMapping("/microservice-produits/produits")
     ResponseEntity<ProductBean> save(@RequestBody ProductBean produit);
}
