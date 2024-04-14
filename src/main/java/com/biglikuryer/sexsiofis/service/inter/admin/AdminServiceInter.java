package com.biglikuryer.sexsiofis.service.inter.admin;

import com.biglikuryer.sexsiofis.dto.admin.AdminDto;
import org.springframework.http.ResponseEntity;

public interface AdminServiceInter {

    AdminDto getAdminById(Long id);

    AdminDto updateAdmin(Long id, AdminDto adminDto);

    ResponseEntity<AdminDto> createAdmin(AdminDto adminDto);

}
