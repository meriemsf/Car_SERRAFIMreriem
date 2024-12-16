package org.example.car.service;

import org.example.car.dto.CarDTO;
import org.example.car.dao.entities.Car;
import org.example.car.mapper.CarMapper;
import org.example.car.dao.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarMapper carMapper;

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.fromCarDTOToCar(carDTO);
        car = carRepository.save(car);
        carDTO = carMapper.fromCarToCarDTO(car);
        return carDTO;

        //return carMapper.fromCarToCarDTO(carRepository.save(carMapper.fromCarDTOToCar(carDTO)));
    }

    @Override
    public boolean deleteCar(Long id) {
        try {
            carRepository.deleteById(id);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

    @Override
    public List<CarDTO> getCarByModel(String model) {
        List<Car> cars = carRepository.findByModel(model);
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            carDTOs.add(carMapper.fromCarToCarDTO(car));
        }
        return carDTOs;
    }

    @Override
    public List<CarDTO> getCarByModelAndPrice(String model, double price) {
        List<Car> cars = carRepository.findByModelAndPrice(model, price);
        List<CarDTO> carDTOs = new ArrayList<>();
        for (Car car : cars) {
            carDTOs.add(carMapper.fromCarToCarDTO(car));
        }
        return carDTOs;
    }

    @Override
    public List<CarDTO> saveCars(List<CarDTO> carDTOs) {
        List<Car> cars = new ArrayList<>();
        for (CarDTO carDTO : carDTOs) {
            cars.add(carMapper.fromCarDTOToCar(carDTO));
        }

        cars = carRepository.saveAll(cars);

        carDTOs = new ArrayList<>();
        for (Car car : cars) {
            carDTOs.add(carMapper.fromCarToCarDTO(car));
        }
        return carDTOs;
    }
}
