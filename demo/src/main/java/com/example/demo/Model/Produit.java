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
@Data
@Table(name = "\"Produit\"")
public class Produit {
  @EmbeddedId
  private ProduitId id;

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

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_famille", nullable = false)
  private Famille idFamille;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "id_filiale", nullable = false)
  private Filiale idFiliale;

  @ManyToMany
  @JoinTable(name = "produit_fournisseur",
    joinColumns = @JoinColumn(name = "Ref_piece"),
    inverseJoinColumns = @JoinColumn(name = "id_four"))
  private Set<Fournisseur> fournisseurs = new LinkedHashSet<>();

  @ManyToMany
  @JoinTable(name = "produit_fabricant",
    joinColumns = @JoinColumn(name = "Ref_piece"),
    inverseJoinColumns = @JoinColumn(name = "id_fab"))
  private Set<Fabricant> fabricants = new LinkedHashSet<>();


}
