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
@Table(name = "fabricant")
public class Fabricant {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_fab", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_fab")
  private String nom_fab;

  @NotBlank
  @Size(max = 20)
  @Column(name = "type_fab")
  private String type_fab;

  @ManyToMany
  @JoinTable(name = "produit_fabricant",
    joinColumns = @JoinColumn(name = "id_fab"),
    inverseJoinColumns = @JoinColumn(name = "Ref_piece"))
  private Set<Produit> produits = new LinkedHashSet<>();

}
