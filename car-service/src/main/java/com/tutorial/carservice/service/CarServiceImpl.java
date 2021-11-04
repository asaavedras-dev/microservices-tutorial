package com.tutorial.carservice.service;


import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public Car findById(int id) {
        return carRepository.getById(id);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> findByUserId(int userId) {
        return carRepository.findByUserId(userId);
    }
}
