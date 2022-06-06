package com.example.demo.Repository;

import com.example.demo.Model.Fabricant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricantRepository extends JpaRepository<Fabricant, Long> {
<<<<<<< HEAD
  Fabricant findByNom(String nom_fab);
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
}
