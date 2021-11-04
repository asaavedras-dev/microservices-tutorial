package com.tutorial.carservice.controller;

import com.tutorial.carservice.entity.Car;
import com.tutorial.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> findALl(){
        List<Car> cars = carService.findAll();
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findById(@PathVariable int id){
        Car car = carService.findById(id);
        if(car == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(car);
    }

    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        Car carNew = carService.save(car);
        return ResponseEntity.ok(carNew);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Car>> findByUserId(@PathVariable int userId){
        List<Car> cars = carService.findByUserId(userId);
        if(cars.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cars);
    }







}
