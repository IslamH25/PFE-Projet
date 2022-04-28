package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @NotBlank
  @Size(max = 20)
  private String username;
  @NotBlank
  @Size(max = 120)
  private String password;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(	name = "user_roles",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Roles> roles = new HashSet<>();

}
