package org.example.car.service;

import org.example.car.dto.CarDTO;

import java.util.List;

public interface CarService {
    public CarDTO saveCar(CarDTO carDto);
    public boolean deleteCar(Long id);
    public List<CarDTO> getCarByModel(String model);
    public List<CarDTO> getCarByModelAndPrice(String model, double price);
    public List<CarDTO> saveCars(List<CarDTO> carDtos);

}
