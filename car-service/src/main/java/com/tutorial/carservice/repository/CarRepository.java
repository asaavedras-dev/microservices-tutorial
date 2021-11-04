package com.tutorial.carservice.repository;

import com.tutorial.carservice.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {

    public List<Car> findByUserId(int userId);
}
