package com.example.demo.Services;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

  @Autowired
  UserRepository userRepository;

  @Override
  public void saveUser(User user) {
      userRepository.save(user);
  }
}
