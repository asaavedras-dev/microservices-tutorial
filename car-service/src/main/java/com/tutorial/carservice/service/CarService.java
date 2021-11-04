package com.tutorial.carservice.service;

import com.tutorial.carservice.entity.Car;

import java.util.List;

public interface CarService {

    public List<Car> findAll();

    public Car findById(int id);

    public Car save(Car car);

    public List<Car> findByUserId(int userId);
}
