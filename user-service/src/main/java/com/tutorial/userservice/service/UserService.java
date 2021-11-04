package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.models.Car;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User getById(int id);

    public User save(User user);

    public List<Car> getCars(int id);

    public Car saveCar(int userId, Car car);
}
