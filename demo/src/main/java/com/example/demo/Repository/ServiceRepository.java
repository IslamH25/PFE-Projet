package com.example.demo.Repository;

import com.example.demo.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
<<<<<<< HEAD
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
  Service findByNom(String nom);
=======

public interface ServiceRepository extends JpaRepository<Service, Long> {
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
}
