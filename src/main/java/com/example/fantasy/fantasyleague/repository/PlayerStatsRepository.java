package com.example.fantasy.fantasyleague.repository;

import com.example.fantasy.fantasyleague.model.PlayerStats;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerStatsRepository extends JpaRepository<PlayerStats, Long> {
    List<PlayerStats> findByMatchId(Long matchId);
}
