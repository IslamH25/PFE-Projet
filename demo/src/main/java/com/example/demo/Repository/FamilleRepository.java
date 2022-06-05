package com.example.demo.Repository;

import com.example.demo.Model.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Long> {
  Famille findByNom(String nom_famille);
}
