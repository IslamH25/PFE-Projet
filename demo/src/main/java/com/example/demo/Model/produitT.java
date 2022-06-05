package com.example.demo.Model;

import java.util.HashSet;
import java.util.Set;

public class produitT {
  private Long ref;
  private String consomAnnee;
  private String prix;
  private String observation;
  private String designation;
  private String nom_fil;
  private  String nom_fam;
  private Set<Fabricant> fabricants = new HashSet<>();
  private Set<Fournisseur> fournisseurs = new HashSet<>();

  public String getConsomAnnee() {
    return consomAnnee;
  }

  public void setConsomAnnee(String consomAnnee) {
    this.consomAnnee = consomAnnee;
  }

  public Long getRef() {
    return ref;
  }

  public void setRef(Long ref) {
    this.ref = ref;
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

  public void setObservation(String observation) {
    this.observation = observation;
  }

  public String getDesignation() {
    return designation;
  }

  public void setDesignation(String designation) {
    this.designation = designation;
  }

  public String getNom_fil() {
    return nom_fil;
  }

  public void setNom_fil(String nom_fil) {
    this.nom_fil = nom_fil;
  }

  public String getNom_fam() {
    return nom_fam;
  }

  public void setNom_fam(String nom_fam) {
    this.nom_fam = nom_fam;
  }

  public Set<Fabricant> getFabricants() {
    return fabricants;
  }

  public void setFabricants(Set<Fabricant> fabricants) {
    this.fabricants = fabricants;
  }

  public Set<Fournisseur> getFournisseurs() {
    return fournisseurs;
  }

  public void setFournisseurs(Set<Fournisseur> fournisseurs) {
    this.fournisseurs = fournisseurs;
  }

  @Override
  public String toString() {
    return "produitT{" +
      "ref=" + ref +
      ", consomAnnee='" + consomAnnee + '\'' +
      ", prix='" + prix + '\'' +
      ", observation='" + observation + '\'' +
      ", designation='" + designation + '\'' +
      ", nom_fil='" + nom_fil + '\'' +
      ", nom_fam='" + nom_fam + '\'' +
      ", fabricants=" + fabricants +
      ", fournisseurs=" + fournisseurs +
      '}';
  }
}
