package com.example.stadium_pro.service.impl;

import com.example.stadium_pro.model.dto.TeamMatchDTO;
import com.example.stadium_pro.model.dto.responseDto.TeamMatchRespDTO;
import com.example.stadium_pro.model.entity.TeamMatch;
import com.example.stadium_pro.model.identity.TeamMatchId;
import com.example.stadium_pro.repository.TeamMatchRepository;
import com.example.stadium_pro.service.MatchService;
import com.example.stadium_pro.service.TeamMatchService;
import com.example.stadium_pro.service.TeamService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TeamMatchServiceImpl implements TeamMatchService {
    private final TeamMatchRepository teamMatchRepository;
    private final TeamService teamService;
    private final MatchService matchService;
    private final ModelMapper modelMapper;

    @Autowired
    public TeamMatchServiceImpl(TeamMatchRepository teamMatchRepository, TeamService teamService, MatchService matchService, ModelMapper modelMapper) {
        this.teamMatchRepository = teamMatchRepository;
        this.teamService = teamService;
        this.matchService = matchService;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TeamMatchRespDTO> getAllTeamMatches() {
        try {
            if (teamService.getAllTeams().isEmpty()) {
                throw new RuntimeException("No teams found");
            }
            if (matchService.getAllMatches().isEmpty()) {
                throw new RuntimeException("No matches found");
            }
            List<TeamMatch> teamMatches = teamMatchRepository.findAll();
            return teamMatches.stream()
                    .map(teamMatch -> modelMapper.map(teamMatch, TeamMatchRespDTO.class))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch all team matches: " + e.getMessage());
        }
    }

    @Override
    public TeamMatchDTO createTeamMatch(TeamMatchDTO teamMatchDTO) {
        try {
            if (teamService.getTeamById(teamMatchDTO.getTeamId()) == null) {
                throw new RuntimeException("Team not found with ID: " + teamMatchDTO.getTeamId());
            }
            if (matchService.getMatchById(teamMatchDTO.getMatchId()) == null) {
                throw new RuntimeException("Match not found with ID: " + teamMatchDTO.getMatchId());
            }
            TeamMatch teamMatch = modelMapper.map(teamMatchDTO, TeamMatch.class);
            teamMatch = teamMatchRepository.save(teamMatch);
            return modelMapper.map(teamMatch, TeamMatchDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to create team match: " + e.getMessage());
        }
    }

    @Override
    public void deleteTeamMatch(TeamMatchId teamMatchId) {
        try {
            teamMatchRepository.findById(teamMatchId).ifPresent(teamMatchRepository::delete);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete team match: " + e.getMessage());
        }
    }

    @Override
    public TeamMatchDTO updateTeamMatch(TeamMatchId teamMatchId, TeamMatchDTO teamMatchDTO) {
        TeamMatch teamMatch = teamMatchRepository.findById(teamMatchId)
                .orElseThrow(() -> new RuntimeException("Team match not found with ID: " + teamMatchId));
        if (teamMatch != null) {
            teamMatch.setTime(String.valueOf(teamMatchDTO.getTime()));
            teamMatch.setDate(String.valueOf(teamMatchDTO.getDate()));
            teamMatch.setTeamsName(teamMatchDTO.getTeamsName());

            teamMatch = teamMatchRepository.save(teamMatch);
            return modelMapper.map(teamMatch, TeamMatchDTO.class);
        }
        return null;
    }


}
