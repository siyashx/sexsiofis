package com.biglikuryer.sexsiofis.api.admin.controller;

import com.biglikuryer.sexsiofis.dto.admin.AdminDto;
import com.biglikuryer.sexsiofis.service.impl.admin.AdminServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v3/create/admin")
public class AdminRegisterController {

    private final AdminServiceImpl adminServiceImpl;

    public AdminRegisterController(AdminServiceImpl adminServiceImpl) {
        this.adminServiceImpl = adminServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody AdminDto adminDto) {
        return adminServiceImpl.createAdmin(adminDto);
    }
}
