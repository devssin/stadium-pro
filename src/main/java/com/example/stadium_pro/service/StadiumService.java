// StadiumService.java
package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.StadiumDTO;
import com.example.stadium_pro.model.dto.responseDto.StadiumRespDTO;

import java.util.List;

public interface StadiumService {
    List<StadiumRespDTO> getAllStadiums();
    StadiumDTO getStadiumById(Long stadiumId);
    StadiumDTO createStadium(StadiumDTO stadiumDTO);
    StadiumDTO updateStadium(Long stadiumId, StadiumDTO stadiumDTO);
    void deleteStadium(Long stadiumId);
}
