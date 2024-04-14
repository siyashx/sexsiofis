package com.biglikuryer.sexsiofis.api.courier.controller;

import com.biglikuryer.sexsiofis.dto.courier.CourierDto;
import com.biglikuryer.sexsiofis.service.impl.courier.CourierServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v4/create/courier")
public class CourierRegisterController {
    private final CourierServiceImpl courierServiceImpl;

    public CourierRegisterController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    // Create
    @PostMapping
    public ResponseEntity<?> createCourier(@RequestBody CourierDto courierDto) {
        return courierServiceImpl.createCourier(courierDto);
    }
}
