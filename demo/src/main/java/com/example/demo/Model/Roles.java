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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private ERole name;
  }


