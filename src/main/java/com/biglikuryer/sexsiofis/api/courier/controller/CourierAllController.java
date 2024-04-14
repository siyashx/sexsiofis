package com.biglikuryer.sexsiofis.api.courier.controller;

import com.biglikuryer.sexsiofis.dto.courier.CourierDto;
import com.biglikuryer.sexsiofis.service.impl.courier.CourierServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v4/couriers")
public class CourierAllController {
    private final CourierServiceImpl courierServiceImpl;

    public CourierAllController(CourierServiceImpl courierServiceImpl) {
        this.courierServiceImpl = courierServiceImpl;
    }

    // List
    @GetMapping
    public List<CourierDto> getAllCouriers() {
        return courierServiceImpl.getAllCouriers();
    }
}
