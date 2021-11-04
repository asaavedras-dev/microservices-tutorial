package com.tutorial.userservice.service;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.feignclient.CarFeignClient;
import com.tutorial.userservice.models.Car;
import com.tutorial.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CarFeignClient carFeignClient;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Car> getCars(int userId) {
        List<Car> cars = restTemplate.getForObject("http://localhost:8082/byUser/"+userId,List.class);
        return cars;
    }

    @Override
    public Car saveCar(int userId, Car car) {
        Car carNew = carFeignClient.save(car);
        return carNew;
    }
}
