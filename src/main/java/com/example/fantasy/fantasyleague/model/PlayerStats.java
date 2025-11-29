package com.example.fantasy.fantasyleague.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long playerId;
    private Long matchId;

    private int minutesPlayed;
    private int goals;
    private int assists;
    private int conceded;
    private boolean cleanSheet;
    private boolean yellowCard;
    private boolean redCard;
    private boolean penaltyScored;
    private boolean penaltyMissed;

}
