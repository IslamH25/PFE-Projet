package com.example.demo.Repository;

import com.example.demo.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
  Fournisseur findByNom(String nom_four);
}
