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
@Table(name = "service")
public class Service {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_serv", nullable = false)
  private Long id;

  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_serv")
  private String nom_serv;


  @NotBlank
  @Size(max = 20)
  @Column(name = "designation_serv")
  private String designation_serv;

  @ManyToMany
  @JoinTable(name = "filiale_service",
    joinColumns = @JoinColumn(name = "id_serv"),
    inverseJoinColumns = @JoinColumn(name = "id_fil"))
  private Set<Filiale> filiales = new LinkedHashSet<>();



}
