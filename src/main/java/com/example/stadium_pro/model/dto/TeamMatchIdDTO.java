package com.example.stadium_pro.model.dto;

import jakarta.persistence.Embeddable;
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
public class TeamMatchIdDTO implements Serializable {

    private long teamId;
    private long matchId;


}
