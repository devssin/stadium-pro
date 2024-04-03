package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.TeamMatchDTO;
import com.example.stadium_pro.model.dto.responseDto.TeamMatchRespDTO;
import com.example.stadium_pro.model.identity.TeamMatchId;

import java.util.List;

public interface TeamMatchService {
    List<TeamMatchRespDTO> getAllTeamMatches();
    TeamMatchDTO createTeamMatch(TeamMatchDTO teamMatchDTO);
    void deleteTeamMatch(TeamMatchId teamMatchId);
    TeamMatchDTO updateTeamMatch(TeamMatchId teamMatchId, TeamMatchDTO teamMatchDTO);
}
