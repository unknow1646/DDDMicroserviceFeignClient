package com.example.globantpersonalproject.application.security.config.service;

import com.example.globantpersonalproject.application.security.config.UserDetailsImpl;
import com.example.globantpersonalproject.application.security.config.modelsecurity.User;
import com.example.globantpersonalproject.application.security.config.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceimpl implements UserDetailsService {

  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepository.findOneByEmail(email)
        .orElseThrow(() -> new UsernameNotFoundException("El usuario con el email: " + email + " No existe"));

    return new UserDetailsImpl(user);
  }
}
