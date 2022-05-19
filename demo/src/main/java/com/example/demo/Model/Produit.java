package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_piece", nullable = false)
    private Long ref_piece;

  @Column(name = "consom_annee")
  private Long consomAnnee;

  @NotBlank
  @Size(max = 20)
  @Column(name = "prix")
  private String prix;

  @NotBlank
  @Size(max = 20)
  @Column(name = "observation")
  private String observation;

  @NotBlank
  @Size(max = 20)
  @Column(name = "designation")
  private String designation;


  public Long getRef_piece() {
    return ref_piece;
  }

  public void setRef_piece(Long ref_piece) {
    this.ref_piece = ref_piece;
  }

  public Long getConsomAnnee() {
    return consomAnnee;
  }

  public void setConsomAnnee(Long consomAnnee) {
    this.consomAnnee = consomAnnee;
  }

  public String getPrix() {
    return prix;
  }

  public void setPrix(String prix) {
    this.prix = prix;
  }

  public String getObservation() {
    return observation;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public void setObservation(String observation) {
    this.observation = observation;
  }



  @Override
  public String toString() {
    return "Produit{" +
      "ref_piece=" + ref_piece +
      ", consomAnnee=" + consomAnnee +
      ", prix='" + prix + '\'' +
      ", observation='" + observation + '\'' +
      ", designation='" + designation +

      '}';
  }
}
