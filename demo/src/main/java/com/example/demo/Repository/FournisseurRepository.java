package com.example.demo.Repository;

import com.example.demo.Model.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FournisseurRepository extends JpaRepository<Fournisseur, Long> {
<<<<<<< HEAD
  Fournisseur findByNom(String nom_four);
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
}
