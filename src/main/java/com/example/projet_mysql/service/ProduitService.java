package com.example.projet_mysql.service;

import com.example.projet_mysql.modele.Produit;
import com.example.projet_mysql.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {
    @Autowired
    private ProduitRepository produitRepository;

    public void saveProduit(Produit produit)
    {
        produitRepository.save(produit);
    }

    public List<Produit> showProduits()
    {
        return produitRepository.findAll();
    }
    private Produit showProduitOne(int id)
    {
        Optional<Produit> optional = produitRepository.findById(id);
        Produit produit = null;

        if (optional.isPresent())
        {
            produit = optional.get();
        }
        else
        {
            throw new RuntimeException("Id Introuvable");
        }

        return produit;
    }
    public void deleteProduit(int id)
    {
        produitRepository.deleteById(id);
    }


}
