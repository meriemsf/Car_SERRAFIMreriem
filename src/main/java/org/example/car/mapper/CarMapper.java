package org.example.car.mapper;

import org.example.car.dao.entities.Car;
import org.example.car.dto.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper mapper = new ModelMapper();
    public Car fromCarDTOToCar(CarDTO CarDto){
        return mapper.map(CarDto, Car.class);
    }

    public CarDTO fromCarToCarDTO(Car car){
        return mapper.map(car, CarDTO.class);
    }


}
