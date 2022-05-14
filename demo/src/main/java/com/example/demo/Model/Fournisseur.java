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
@Table(name = "fournisseur")
public class Fournisseur {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_four", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_four")
  private String nom_four;

  @ManyToMany
  @JoinTable(name = "produit_fournisseur",
    joinColumns = @JoinColumn(name = "id_four"),
    inverseJoinColumns = @JoinColumn(name = "Ref_piece"))
  private Set<Produit> produits = new LinkedHashSet<>();


}
