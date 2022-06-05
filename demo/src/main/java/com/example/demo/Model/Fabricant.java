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
@Table(name = "fabricant")
public class Fabricant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_fab", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_fab")
  private String nom;

  @NotBlank
  @Size(max = 20)
  @Column(name = "type_fab")
  private String type_fab;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom_fab() {
    return nom;
  }

  public void setNom_fab(String nom_fab) {
    this.nom = nom_fab;
  }

  public String getType_fab() {
    return type_fab;
  }

  public void setType_fab(String type_fab) {
    this.type_fab = type_fab;
  }

  @Override
  public String toString() {
    return "Fabricant{" +
      "id=" + id +
      ", nom_fab='" + nom + '\'' +
      ", type_fab='" + type_fab + '\'' +
      '}';
  }
}
