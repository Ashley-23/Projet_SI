package com.example.projet_mysql.controller;

import com.example.projet_mysql.modele.Produit;
import com.example.projet_mysql.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("Produit")
public class ProduitController {
    @Autowired
    private ProduitService produitService;

    @GetMapping("/afficher")
    public String displayProduct(Model model)
    {
        model.addAttribute("listeproduit",produitService.showProduits());
        return "Produit/product";
    }

    @GetMapping("/form")
    public String saisirProduit()
    {
        return "Produit/saisirProduit";
    }
    @PostMapping("/save")
    public String save(Produit produit)
    {
        produit.setDateCreation(LocalDate.now());
        produit.setQteStock(0);
        produitService.saveProduit(produit);
        return "redirect:/produit/afficher";
    }
}
