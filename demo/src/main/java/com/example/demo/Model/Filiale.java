package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
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
<<<<<<< HEAD
  private String nom;
=======
  private String nom_fil;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  @NotBlank
  @Size(max = 20)
  @Column(name = "desc_fil")
  private String desc_fil;

  @NotBlank
  @Size(max = 20)
  @Column(name = "sect_act")
  private String sect_fil;
<<<<<<< HEAD
=======

>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "filiale_service",
    joinColumns = @JoinColumn(name = "id_fil"),
    inverseJoinColumns = @JoinColumn(name = "id_serv"))
<<<<<<< HEAD
  private Set<Service>  service = new HashSet<>();

  public Long getId() {
    return id;
  }
=======
  private Set<Service> service = new HashSet<>();

>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  public Set<Service> getService() {
    return service;
  }

  public void setService(Set<Service> service) {
    this.service = service;
  }

<<<<<<< HEAD
=======
  public Long getId() {
    return id;
  }

>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  public void setId(Long id) {
    this.id = id;
  }

<<<<<<< HEAD
  public String getNom_fil() {return nom;}

  public void setNom_fil(String nom_fil) {
    this.nom = nom_fil;
=======
  public String getNom_fil() {
    return nom_fil;
  }

  public void setNom_fil(String nom_fil) {
    this.nom_fil = nom_fil;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
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
<<<<<<< HEAD
      ", nom_fil='" + nom + '\'' +
      ", desc_fil='" + desc_fil + '\'' +
      ", sect_fil='" + sect_fil + '\'' +
      ", service=" + service +
=======
      ", nom_fil='" + nom_fil + '\'' +
      ", desc_fil='" + desc_fil + '\'' +
      ", sect_fil='" + sect_fil + '\'' +
      ", service='" + service +
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
      '}';
  }
}
