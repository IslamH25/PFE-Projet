package com.example.demo.Repository;

import com.example.demo.Model.Produit;
import com.example.demo.Model.ProduitId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, ProduitId> {
}
