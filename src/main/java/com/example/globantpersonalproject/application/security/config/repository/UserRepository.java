package com.example.globantpersonalproject.application.security.config.repository;

import com.example.globantpersonalproject.application.security.config.modelsecurity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByEmail(String email);

}
