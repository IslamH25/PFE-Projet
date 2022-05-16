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
@Table(name = "famille")
public class Famille {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_famille", nullable = false)
  private Long id;


  @NotBlank
  @Size(max = 20)
  @Column(name = "nom_famille")
  private String nom_famille;


  @NotBlank
  @Size(max = 20)
  @Column(name = "desc_famille")
  private String desc_famille;



}
