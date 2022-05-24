package com.example.demo.Repository;


import com.example.demo.Model.ERole;
import com.example.demo.Model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
  Optional<Roles> findByName(ERole name);
}
