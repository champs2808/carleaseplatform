package com.CarLeaseProject.carmicroservice.controller;

import com.CarLeaseProject.carmicroservice.model.CarEntity;
import com.CarLeaseProject.carmicroservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CarController {

  @Autowired private CarService carService;

  @GetMapping("/cars")
  public ResponseEntity<List<CarEntity>> getAllCars() {
    try {
      List<CarEntity> carEntityList = carService.getAllCars();
      if (carEntityList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(carEntityList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/cars/{id}")
  public ResponseEntity<CarEntity> getCarByID(@PathVariable("id") Long id) {
    try {
      Optional<CarEntity> customer = carService.getCarByID(id);
      return customer
          .map(car -> new ResponseEntity<>(car, HttpStatus.OK))
          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/cars/fetchByModelandVersion")
  public ResponseEntity<List<CarEntity>> getCarByModelAndVersion(@RequestParam String model, String version) {
    try {
      if (!carService.getCarByModelAndVersion(model, version).isEmpty()) {
        return new ResponseEntity<>(
            carService.getCarByModelAndVersion(model, version), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/cars")
  public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity car) {
    try {
      CarEntity carEntity = carService.createCar(car);
      return new ResponseEntity<>(carEntity, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/cars/{id}")
  public ResponseEntity<CarEntity> updateCar(@PathVariable("id") Long id, CarEntity car) {
    try {
      if (carService.updateCar(id, car) != null) {
        return new ResponseEntity<>(carService.updateCar(id, car), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/cars/{id}")
  public ResponseEntity<HttpStatus> deleteCarById(@PathVariable("id") long id) {
    try {
      carService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
