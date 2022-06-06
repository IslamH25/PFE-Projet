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
@Table(name = "famille")
public class Famille {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_famille", nullable = false)
  private Long id;


  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_famille")
<<<<<<< HEAD
  private String nom;
=======
  private String nom_famille;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76


  @NotBlank
  @Size(max = 20)
  @Column(name = "desc_famille")
  private String desc_famille;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom_famille() {
<<<<<<< HEAD
    return nom;
  }

  public void setNom_famille(String nom_famille) {
    this.nom = nom_famille;
=======
    return nom_famille;
  }

  public void setNom_famille(String nom_famille) {
    this.nom_famille = nom_famille;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }

  public String getDesc_famille() {
    return desc_famille;
  }

<<<<<<< HEAD
  public void setDesc_famille(String desc_famille) {this.desc_famille = desc_famille;}

  @Override
  public String toString() {
    return "Famille{" +
      "id=" + id +
      ", nom='" + nom + '\'' +
      ", desc_famille='" + desc_famille + '\'' +
      '}';
=======
  public void setDesc_famille(String desc_famille) {
    this.desc_famille = desc_famille;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }
}
