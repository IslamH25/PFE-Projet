package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fournisseur")
public class Fournisseur {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_four", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_four")
<<<<<<< HEAD
  private String nom;
=======
  private String nom_four;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  public Long getId() {
    return id;
  }

  public String getNom_four() {
<<<<<<< HEAD
    return nom;
  }

  public void setNom_four(String nom_four) {
    this.nom = nom_four;
=======
    return nom_four;
  }

  public void setNom_four(String nom_four) {
    this.nom_four = nom_four;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return "Fournisseur{" +
      "id=" + id +
<<<<<<< HEAD
      ", nom_four='" + nom + '\'' +
=======
      ", nom_four='" + nom_four + '\'' +
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
      '}';
  }
}
