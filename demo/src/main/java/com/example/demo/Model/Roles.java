package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roles {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", nullable = false)
  private Long id;
  private String libelle;
  }


