package com.example.stadium_pro.model.identity;

import com.example.stadium_pro.model.entity.Match;
import com.example.stadium_pro.model.entity.Team;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Embeddable
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TeamMatchId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;
}
