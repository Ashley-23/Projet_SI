package com.example.projet_mysql.repository;

import com.example.projet_mysql.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository <Produit,Integer> {


}
