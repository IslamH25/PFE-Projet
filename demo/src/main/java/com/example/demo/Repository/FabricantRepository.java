package com.example.demo.Repository;

import com.example.demo.Model.Fabricant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricantRepository extends JpaRepository<Fabricant, Long> {
  Fabricant findByNom(String nom_fab);
}
