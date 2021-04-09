package com.ecommerce.mpaiement.repository;

import com.ecommerce.mpaiement.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Long> {
    Paiement findByidCommande(Long idCommande);
}
