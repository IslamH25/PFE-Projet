package com.example.demo.Controller;

import com.example.demo.Model.ERole;
import com.example.demo.Model.Roles;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.domaine.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<User> getAllUsers(){
    System.out.println(userRepository.findAll());
    return userRepository.findAll();  }

  @PostMapping("/users")
  public void CreateUser(@RequestBody Map<String,String> object){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    User user = new User();
    user.setUsername(object.get("username"));
    String pass = passwordEncoder.encode(object.get("password"));
    user.setPassword(pass);
    Set<Roles> roles = new HashSet<Roles>() ;
    Roles role = new Roles();
    switch(object.get("roles")){
      case "ROLE_ADMIN":
        role.setName(ERole.ROLE_ADMIN);
        role.setId(3L);
        break;
      case "ROLE_USER":
        role.setName(ERole.ROLE_USER);
        role.setId(1L);
    }
    roles.add(role);
    user.setRoles(roles);
    userRepository.save(user);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable Long id){
    User user = userRepository.findById(id)
      .orElseThrow(() -> new RessourceNotFoundException("User not exist with id :" +id));
    return ResponseEntity.ok(user);
  }
  @PutMapping(value = "/users/{id}")
  public ResponseEntity<User>  updateUser(@PathVariable Long id,@RequestBody Map<String,String> object ){
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    User user = userRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("User not exist with id :" +id));
     user.setUsername(object.get("username"));
    String pass = passwordEncoder.encode(object.get("password"));
     user.setPassword(pass);
    Set<Roles> roles = new HashSet<Roles>() ;
    Roles role = new Roles();
    switch(object.get("roles")){
      case "ROLE_ADMIN":
        role.setName(ERole.ROLE_ADMIN);
        role.setId(3L);
        break;
      case "ROLE_USER":
        role.setName(ERole.ROLE_USER);
        role.setId(1L);
    }
    roles.add(role);
    user.setRoles(roles);
     User updatedUser = userRepository.save(user);

     return ResponseEntity.ok(updatedUser);

  }
  @DeleteMapping("/users/{id}")
  public ResponseEntity<Map<String,Boolean>> DeleteUser(@PathVariable Long id){
    User user= userRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("User not exist with id :" +id));
    userRepository.delete(user);
    Map<String,Boolean> response=new HashMap<>();
    response.put("deleted",Boolean.TRUE);
    return  ResponseEntity.ok(response);
  }

}
