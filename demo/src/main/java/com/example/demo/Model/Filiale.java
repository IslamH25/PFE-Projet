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
@Table(name = "filiale")
public class Filiale {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_fil", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_fil")
  private String nom_fil;

  @NotBlank
  @Size(max = 20)
  @Column(name = "desc_fil")
  private String desc_fil;

  @NotBlank
  @Size(max = 20)
  @Column(name = "sect_act")
  private String sect_fil;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNom_fil() {
    return nom_fil;
  }

  public void setNom_fil(String nom_fil) {
    this.nom_fil = nom_fil;
  }

  public String getDesc_fil() {
    return desc_fil;
  }

  public void setDesc_fil(String desc_fil) {
    this.desc_fil = desc_fil;
  }

  public String getSect_fil() {
    return sect_fil;
  }

  public void setSect_fil(String sect_fil) {
    this.sect_fil = sect_fil;
  }

  @Override
  public String toString() {
    return "Filiale{" +
      "id=" + id +
      ", nom_fil='" + nom_fil + '\'' +
      ", desc_fil='" + desc_fil + '\'' +
      ", sect_fil='" + sect_fil + '\'' +
      '}';
  }
}
