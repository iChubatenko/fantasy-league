package com.example.fantasy.fantasyleague.repository;

import com.example.fantasy.fantasyleague.model.MatchBonus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MatchBonusRepository extends JpaRepository<MatchBonus, Long> {
    Optional<MatchBonus> findByMatchIdAndPlayerId(Long matchId, Long id);
}
