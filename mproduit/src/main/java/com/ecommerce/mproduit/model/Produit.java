package com.ecommerce.mproduit.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Produit {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titre;
    private String description;
    private String image;
    private Double prix;

}
