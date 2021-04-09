package com.ecommerce.mcommande.repository;

import com.ecommerce.mcommande.model.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Commande findById(Commande commande);
}
