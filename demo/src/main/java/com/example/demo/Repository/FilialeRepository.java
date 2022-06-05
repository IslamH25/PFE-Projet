package com.example.demo.Repository;

import com.example.demo.Model.Filiale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialeRepository extends JpaRepository<Filiale, Long> {
  Filiale findByNom(String nom_fil);
}
