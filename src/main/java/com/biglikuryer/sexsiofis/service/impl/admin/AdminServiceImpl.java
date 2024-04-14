package com.biglikuryer.sexsiofis.service.impl.admin;

import com.biglikuryer.sexsiofis.dao.admin.AdminRepository;
import com.biglikuryer.sexsiofis.dto.admin.AdminDto;
import com.biglikuryer.sexsiofis.model.admin.Admin;
import com.biglikuryer.sexsiofis.service.inter.admin.AdminServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminServiceInter {

    private final AdminRepository adminRepository;

    private final ModelMapper modelMapper;

    public AdminServiceImpl(AdminRepository adminRepository, ModelMapper modelMapper) {
        this.adminRepository = adminRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AdminDto getAdminById(Long id) {
        Admin entity = adminRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, AdminDto.class);
        }
        return null;
    }

    @Override
    public AdminDto updateAdmin(Long id, AdminDto adminDto) {
        Optional<Admin> adminOptional = adminRepository.findById(id);

        if (adminOptional.isPresent()) {
            Admin admin = adminOptional.get();

            if (adminDto.getOneSignal() != null) {
                admin.setOneSignal(adminDto.getOneSignal());
            }

            admin = adminRepository.save(admin);
            return modelMapper.map(admin, AdminDto.class);
        }
        return null;
     }

    @Override
    public ResponseEntity<AdminDto> createAdmin(AdminDto adminDto) {
        Admin adminEntity = modelMapper.map(adminDto, Admin.class);
        Admin savedAdmin = adminRepository.save(adminEntity);
        return ResponseEntity.ok(modelMapper.map(savedAdmin, AdminDto.class));
    }
}
