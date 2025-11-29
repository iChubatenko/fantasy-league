package com.example.fantasy.fantasyleague.repository;

import com.example.fantasy.fantasyleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
