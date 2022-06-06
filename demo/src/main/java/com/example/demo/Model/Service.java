package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "service")
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_serv", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_serv")
<<<<<<< HEAD
  private String nom;
=======
  private String nom_serv;

>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  @NotBlank
  @Size(max = 20)
  @Column(name = "designation_serv")
  private String designation_serv;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom_serv() {
<<<<<<< HEAD
    return nom;
  }

  public void setNom_serv(String nom_serv) {
    this.nom= nom_serv;
=======
    return nom_serv;
  }

  public void setNom_serv(String nom_serv) {
    this.nom_serv = nom_serv;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }

  public String getDesignation_serv() {
    return designation_serv;
  }

  public void setDesignation_serv(String designation_serv) {
    this.designation_serv = designation_serv;
  }

  @Override
  public String toString() {
    return "Service{" +
      "id=" + id +
<<<<<<< HEAD
      ", nom_serv='" + nom + '\'' +
=======
      ", nom_serv='" + nom_serv + '\'' +
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
      ", designation_serv='" + designation_serv + '\'' +
      '}';
  }
}
