package com.example.fantasy.fantasyleague.service;

import com.example.fantasy.fantasyleague.model.Player;
import com.example.fantasy.fantasyleague.model.PlayerStats;
import org.springframework.stereotype.Service;

@Service
public class ScoringService {

    public int calculatePoints(Player player, PlayerStats stats){
        int points = 0;

        if (stats.getMinutesPlayed() > 0) points += 1;
        if (stats.getMinutesPlayed() > 60) points += 1;

        switch (player.getPosition()) {
            case "FWD": points += stats.getGoals() * 4; break;
            case "MID": points += stats.getGoals() * 5; break;
            case "DEF": points += stats.getGoals() * 6; break;
            case "GK": points += stats.getGoals() * 10; break;
        }

        points += stats.getAssists() * 3;

        if (stats.isCleanSheet() && (player.getPosition().equals("DEF") || player.getPosition().equals("GK"))) {
            points += 4;
        }

        if (stats.isCleanSheet() && player.getPosition().equals("MID")){
            points += 1;
        }

        if (player.getPosition().equals("GK") || player.getPosition().equals("DEF")) {
            points -= stats.getConceded() / 2;
        }

        if (stats.isYellowCard()) points -= 1;
        if (stats.isRedCard()) points -= 3;

        if (stats.isPenaltyScored()) points += 2;
        if (stats.isPenaltyMissed()) points -= 2;

        return points;
    }
}
