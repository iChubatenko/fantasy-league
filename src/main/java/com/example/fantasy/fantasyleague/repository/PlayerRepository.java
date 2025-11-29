package com.example.fantasy.fantasyleague.repository;

import com.example.fantasy.fantasyleague.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
