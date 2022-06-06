package com.example.demo.Repository;

import com.example.demo.Model.Famille;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilleRepository extends JpaRepository<Famille, Long> {
<<<<<<< HEAD
  Famille findByNom(String nom_famille);
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
}
