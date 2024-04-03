// MatchService.java
package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.MatchDTO;
import com.example.stadium_pro.model.dto.responseDto.MatchRespDTO;

import java.util.List;

public interface MatchService {
    List<MatchRespDTO> getAllMatches();
    MatchDTO getMatchById(Long matchId);
    MatchDTO createMatch(MatchDTO matchDTO);
    MatchDTO updateMatch(Long matchId, MatchDTO matchDTO);
    void deleteMatch(Long matchId);
}
