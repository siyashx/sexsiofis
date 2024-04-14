package com.biglikuryer.sexsiofis.dao.admin;

import com.biglikuryer.sexsiofis.model.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
