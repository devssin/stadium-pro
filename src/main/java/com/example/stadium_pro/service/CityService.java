package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.CityDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> getAllCities();
    CityDTO getCityById(Long cityId);
    CityDTO createCity(CityDTO cityDTO);
    CityDTO updateCity(Long cityId, CityDTO cityDTO);
    void deleteCity(Long cityId);
}
