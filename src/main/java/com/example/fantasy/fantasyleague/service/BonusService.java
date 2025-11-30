package com.example.fantasy.fantasyleague.service;

import com.example.fantasy.fantasyleague.model.MatchBonus;
import com.example.fantasy.fantasyleague.model.PlayerStats;
import com.example.fantasy.fantasyleague.repository.MatchBonusRepository;
import com.example.fantasy.fantasyleague.repository.PlayerStatsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BonusService {

    private final PlayerStatsRepository statsRepository;
    private final MatchBonusRepository bonusRepository;

    public void calculateMatchBonuses(Long matchId){
        List<PlayerStats> stats = statsRepository.findByMatchId(matchId);

        stats.sort((a, b) -> Integer.compare(scoreForBonus(b), scoreForBonus(a)));

        for (int i = 0; i < Math.min(3, stats.size()); i++){
            PlayerStats ps = stats.get(i);
            int bonus = (i == 0) ? 3 : (i == 1) ? 2 : 1;
            bonusRepository.save(new MatchBonus(null, matchId, ps.getPlayerId(), bonus));
        }
    }

    private int scoreForBonus(PlayerStats s) {
        return s.getGoals() * 5 + s.getAssists() * 3 + (s.isCleanSheet() ? 2 : 0) - s.getConceded();
    }
}
