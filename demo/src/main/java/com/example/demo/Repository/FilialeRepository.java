package com.example.demo.Repository;

import com.example.demo.Model.Filiale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilialeRepository extends JpaRepository<Filiale, Long> {
<<<<<<< HEAD
  Filiale findByNom(String nom_fil);
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
}
