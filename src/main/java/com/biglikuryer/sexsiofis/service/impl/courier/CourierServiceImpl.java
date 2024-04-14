package com.biglikuryer.sexsiofis.service.impl.courier;

import com.biglikuryer.sexsiofis.dao.courier.CourierRepository;
import com.biglikuryer.sexsiofis.dto.courier.CourierDto;
import com.biglikuryer.sexsiofis.model.courier.Courier;
import com.biglikuryer.sexsiofis.service.inter.courier.CourierServiceInter;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourierServiceImpl implements CourierServiceInter {

    private final CourierRepository courierRepository;
    private final ModelMapper modelMapper;

    public CourierServiceImpl(CourierRepository courierRepository, ModelMapper modelMapper) {
        this.courierRepository = courierRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CourierDto> getAllCouriers() {
        List<CourierDto> listDto = new ArrayList<>();

        List<Courier> listEntity = courierRepository.findAll();

        for (Courier entity : listEntity) {
            CourierDto dto = modelMapper.map(entity, CourierDto.class);
            listDto.add(dto);
        }
        return listDto;
    }

    @Override
    public CourierDto getCourierById(Long id) {
        Courier entity = courierRepository.findById(id).orElse(null);
        if (entity != null) {
            return modelMapper.map(entity, CourierDto.class);
        }
        return null;
    }

    @Override
    public ResponseEntity<CourierDto> createCourier(CourierDto courierDto) {
        Courier courierEntity = modelMapper.map(courierDto, Courier.class);
        if (isCourierPhoneNumberTaken(courierEntity.getPhoneNumber())) {
            return ResponseEntity.badRequest().build();
        }
        Courier savedCourier = courierRepository.save(courierEntity);
        return ResponseEntity.ok(modelMapper.map(savedCourier, CourierDto.class));
    }

    @Override
    public CourierDto updateCourier(Long id, CourierDto courierDto) {
        Optional<Courier> courierOptional = courierRepository.findById(id);
        if (courierOptional.isPresent()) {
            Courier courier = courierOptional.get();

            if (courierDto.getOneSignal() != null) {
                courier.setOneSignal(courierDto.getOneSignal());
            }
            if (courierDto.getName() != null) {
                courier.setName(courierDto.getName());
            }
            if (courierDto.getPhoneNumber() != null) {
                courier.setPhoneNumber(courierDto.getPhoneNumber());
            }

            if (courierDto.getPassword() != null) {
                courier.setPassword(courierDto.getPassword());
            }
            if (courierDto.getLatLong() != null) {
                courier.setLatLong(courierDto.getLatLong());
            }


            courier = courierRepository.save(courier);
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }

    @Override
    public void deleteCourier(Long id) {
        courierRepository.deleteById(id);
    }

    @Override
    public Boolean isCourierPhoneNumberTaken(String phoneNumber) {
        return courierRepository.findCourierByPhoneNumber(phoneNumber) != null;
    }

    @Override
    public CourierDto findCourierByPhoneNumber(String phoneNumber) {
        Courier courier = courierRepository.findCourierByPhoneNumber(phoneNumber);
        if (courier != null) {
            return modelMapper.map(courier, CourierDto.class);
        }
        return null;
    }
}
