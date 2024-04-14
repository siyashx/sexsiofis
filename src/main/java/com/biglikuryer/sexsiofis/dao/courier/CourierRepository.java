package com.biglikuryer.sexsiofis.dao.courier;

import com.biglikuryer.sexsiofis.model.courier.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier, Long> {

    Courier findCourierByPhoneNumber(String phoneNumber);
}
