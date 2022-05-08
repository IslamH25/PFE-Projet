package com.example.demo.Services;

<<<<<<< HEAD
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired
  UserRepository userRepository;
  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username)
      .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
    return MyUserDetails.build(user);
  }
=======
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface MyUserDetailsService {
  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
>>>>>>> c6d297a (Corriger le problème d'authentification)
}
