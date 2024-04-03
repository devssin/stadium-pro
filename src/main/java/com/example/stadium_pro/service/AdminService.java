// AdminService.java
package com.example.stadium_pro.service;

import com.example.stadium_pro.model.dto.AdminDTO;

import java.util.List;

public interface AdminService {
    List<AdminDTO> getAllAdmins();
    AdminDTO getAdminById(Long adminId);
    AdminDTO createAdmin(AdminDTO adminDTO);
    AdminDTO updateAdmin(Long adminId, AdminDTO adminDTO);
    void deleteAdmin(Long adminId);


}
