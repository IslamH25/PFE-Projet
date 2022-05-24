package com.example.demo.Repository;

import com.example.demo.Model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, Long> {
  Service findByNom(String nom);
}
