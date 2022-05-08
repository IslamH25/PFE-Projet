package com.example.demo.Controller;

import com.example.demo.Config.JwtTokenUtil;
<<<<<<< HEAD
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Services.MyUserDetails;
=======
import com.example.demo.Model.ERole;
import com.example.demo.Model.Roles;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Request.LoginRequest;
import com.example.demo.Services.MyUserDetails;
import com.example.demo.Services.UserService;
>>>>>>> c6d297a (Corriger le problème d'authentification)
import com.example.demo.domaine.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
=======
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
>>>>>>> c6d297a (Corriger le problème d'authentification)
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class LoginController {

  @Autowired 	UserRepository repository;
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  UserRepository userRepository;

<<<<<<< HEAD
  @Autowired PasswordEncoder encoder;
=======


  @Autowired
  UserService userService ;
>>>>>>> c6d297a (Corriger le problème d'authentification)

  @Autowired JwtTokenUtil jwtUtils;

  @PostMapping("/signin")
  public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
<<<<<<< HEAD
    System.out.println("hhhh");
    System.out.println(loginRequest.getPassword());
    System.out.println(loginRequest.getUsername());
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
=======
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
    System.out.println("Test : " + authentication);
>>>>>>> c6d297a (Corriger le problème d'authentification)
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken(authentication);

    MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
    List<String> roles = userDetails.getAuthorities().stream()
      .map(item -> item.getAuthority())
      .collect(Collectors.toList());
    return ResponseEntity.ok(new JwtResponse(jwt,
      userDetails.getId(),
      userDetails.getUsername(),
      roles));
<<<<<<< HEAD
  }}
=======
  }

  @PostMapping("/signup")
  public ResponseEntity<?> signUpUSer(@Valid @RequestBody Map<String,String> signUpRequest) {
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    User user = new User();
    user.setId(2L);
    user.setUsername(signUpRequest.get("username"));
    String pass = passwordEncoder.encode(signUpRequest.get("password"));
    user.setPassword(pass);
    Set<Roles> roles = new HashSet<Roles>() ;
    Roles role = new Roles();
    role.setName(ERole.ROLE_ADMIN);
    roles.add(role);
    user.setRoles(roles);
    userService.saveUser(user);
      return ResponseEntity.ok("Success");
  }

}
>>>>>>> c6d297a (Corriger le problème d'authentification)
