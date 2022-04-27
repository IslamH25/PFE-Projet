package com.example.demo.Services;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository repository;

  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
    Optional<User> user = repository.findByUsername(username);
    user.orElseThrow(()-> new UsernameNotFoundException(username + "not found"));
    return user.map(MyUserDetails::new).get();
  }
}
