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
  private String nom;

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
    return nom;
  }

  public void setNom_serv(String nom_serv) {
    this.nom= nom_serv;
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
      ", nom_serv='" + nom + '\'' +
      ", designation_serv='" + designation_serv + '\'' +
      '}';
  }
}
