package com.example.fantasy.fantasyleague.repository;

import com.example.fantasy.fantasyleague.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
