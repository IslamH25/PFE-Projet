package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
<<<<<<< HEAD
  private String consomAnnee;
=======
  private Long consomAnnee;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

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

<<<<<<< HEAD
=======
  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name="id_famille",nullable = false)
  @JsonIgnore
  private Famille famille;

  @ManyToOne(fetch = FetchType.LAZY,optional = false)
  @JoinColumn(name="id_filiale",nullable = false)
  @JsonIgnore
  private Filiale filiale;

>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "produit_fabricant",
    joinColumns = @JoinColumn(name = "ref_piece"),
    inverseJoinColumns = @JoinColumn(name = "id_fab"))
<<<<<<< HEAD
  private Set<Fabricant> fabricants = new HashSet<>();
=======
  private Set<Fabricant> fabricant = new HashSet<>();
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "produit_fournisseur",
    joinColumns = @JoinColumn(name = "ref_piece"),
    inverseJoinColumns = @JoinColumn(name = "id_four"))
<<<<<<< HEAD
  private Set<Fournisseur> fournisseurs = new HashSet<>();

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_fil", nullable = false)
  @JsonIgnore
  private Filiale filiale;
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_famille", nullable = false)
  @JsonIgnore
  private Famille famille;

  public Set<Fabricant> getFabricants() {
    return fabricants;
  }

  public void setFabricants(Set<Fabricant> fabricants) {
    this.fabricants = fabricants;
=======
  private Set<Fournisseur> fournisseur = new HashSet<>();

  public Set<Fournisseur> getFournisseur() {
    return fournisseur;
  }

  public void setFournisseur(Set<Fournisseur> fournisseur) {
    this.fournisseur = fournisseur;
  }

  public Set<Fabricant> getFabricant() {
    return fabricant;
  }

  public void setFabricants(Set<Fabricant> fabricant) {
    this.fabricant = fabricant;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }

  public Long getRef_piece() {
    return ref_piece;
  }

  public void setRef_piece(Long ref_piece) {
    this.ref_piece = ref_piece;
  }
<<<<<<< HEAD
  public String getConsomAnnee() {
    return consomAnnee;
  }

  public void setConsomAnnee(String consomAnnee) {
=======

  public Long getConsomAnnee() {
    return consomAnnee;
  }

  public void setConsomAnnee(Long consomAnnee) {
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
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
<<<<<<< HEAD

  public String getDesignation() {
    return designation;
  }

=======
  public void setObservation(String observation) {
    this.observation = observation;
  }
  public String getDesignation() {
    return designation;
  }
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  public void setDesignation(String designation) {
    this.designation = designation;
  }

<<<<<<< HEAD
  public void setObservation(String observation) {
    this.observation = observation;
  }

  public Set<Fournisseur> getFournisseurs() {
    return fournisseurs;
  }

  public void setFournisseurs(Set<Fournisseur> fournisseurs) {
    this.fournisseurs = fournisseurs;
  }

  public Filiale getFiliale() {
    return filiale;
  }

  public void setFiliale(Filiale filiale) {
    this.filiale = filiale;
  }

  public Famille getFamille() {
    return famille;
  }


  public void setFamille(Famille famille) {
    this.famille = famille;
  }
=======
  public Famille getFamille() { return famille; }

  public void setFamille(Famille famille) { this.famille = famille; }

  public Filiale getFiliale() { return filiale;}

  public void setFiliale(Filiale filiale) { this.filiale = filiale;}
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  @Override
  public String toString() {
    return "Produit{" +
      "ref_piece=" + ref_piece +
<<<<<<< HEAD
      ", consomAnnee='" + consomAnnee + '\'' +
      ", prix='" + prix + '\'' +
      ", observation='" + observation + '\'' +
      ", designation='" + designation + '\'' +
      ", fabricants=" + fabricants +
      ", fournisseurs=" + fournisseurs +
      ", filiale=" + filiale +
      ", famille=" + famille +
=======
      ", consomAnnee=" + consomAnnee +
      ", prix='" + prix + '\'' +
      ", observation='" + observation + '\'' +
      ", designation='" + designation + '\'' +
      ", famille=" + famille + '\'' +
      ", filiale=" + filiale + '\'' +
      ", fabricant=" + fabricant + '\'' +
      ", fournisseur=" + fournisseur +
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
      '}';
  }
}
