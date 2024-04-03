package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.TeamDTO;
import com.example.stadium_pro.model.dto.responseDto.TeamRespDTO;

import java.util.List;

public interface TeamService {
    List<TeamRespDTO> getAllTeams();
    TeamDTO getTeamById(Long teamId);
    TeamDTO createTeam(TeamDTO teamDTO);
    TeamDTO updateTeam(Long teamId, TeamDTO teamDTO);
    void deleteTeam(Long teamId);
}
