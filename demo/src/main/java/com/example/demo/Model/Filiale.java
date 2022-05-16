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
@Data
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

  @OneToMany(mappedBy = "idFiliale")
  private Set<Produit> produits = new LinkedHashSet<>();

  @ManyToMany
  @JoinTable(name = "filiale_service",
    joinColumns = @JoinColumn(name = "id_fil"),
    inverseJoinColumns = @JoinColumn(name = "id_serv"))
  private Set<Service> services = new LinkedHashSet<>();



}
