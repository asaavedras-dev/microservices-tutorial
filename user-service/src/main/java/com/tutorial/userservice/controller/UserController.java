package com.tutorial.userservice.controller;

import com.tutorial.userservice.entity.User;
import com.tutorial.userservice.models.Car;
import com.tutorial.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findALl(){
        List<User> users = userService.findAll();
        if(users.isEmpty()){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id){
        User user = userService.getById(id);
        if(user==null){
            return  ResponseEntity.notFound().build();
        }
        return  ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = userService.save(user);
        return  ResponseEntity.ok(userNew);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable int userId){
        User user = userService.getById(userId);
        if(user==null){
            return  ResponseEntity.notFound().build();
        }
        List<Car> cars = userService.getCars(userId);
        return  ResponseEntity.ok(cars);
    }

    @PostMapping("/savecar/{userid}")
    public ResponseEntity<Car> saveCar(@PathVariable int userID,@RequestBody Car car){
        Car carNew = userService.saveCar(userID,car);
        return ResponseEntity.ok(carNew);
    }
}
