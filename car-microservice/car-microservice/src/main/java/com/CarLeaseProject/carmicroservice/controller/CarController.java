package com.CarLeaseProject.carmicroservice.controller;

import com.CarLeaseProject.carmicroservice.model.CarEntity;
import com.CarLeaseProject.carmicroservice.services.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  Logger logger = LoggerFactory.getLogger(CarController.class);

  /**
   * @return all cars which are present in DB
   */
  @GetMapping("/cars")
  public ResponseEntity<List<CarEntity>> getAllCars() {
    logger.info("Received request for fetching all cars");
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

  /**
   * @param id
   * @return car with provided id
   */
  @GetMapping("/cars/{id}")
  public ResponseEntity<CarEntity> getCarByID(@PathVariable("id") Long id) {
    logger.info("Received request for fetching car with id :{}", id);
    try {
      Optional<CarEntity> customer = carService.getCarByID(id);
      return customer
          .map(car -> new ResponseEntity<>(car, HttpStatus.OK))
          .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * @param model
   * @param version
   * @return car with provided model and version
   */
  @GetMapping("/cars/fetchByModelandVersion")
  public ResponseEntity<CarEntity> getCarByModelAndVersion(
      @RequestParam String model, String version) {
    logger.info("Received request for fetching car with model :{} & version :{}", model, version);
    try {
      if (carService.getCarByModelAndVersion(model, version) != null) {
        return new ResponseEntity<>(
            carService.getCarByModelAndVersion(model, version), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * @param car
   * @return creates car with provided details
   */
  @PostMapping("/cars")
  public ResponseEntity<CarEntity> createCar(@RequestBody CarEntity car) {
    logger.info("Received request for creating car record with details :{}", car);
    try {
      CarEntity carEntity = carService.createCar(car);
      return new ResponseEntity<>(carEntity, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * @param id
   * @param car
   * @return updates specified car
   */
  @PutMapping("/cars/{id}")
  public ResponseEntity<CarEntity> updateCar(@PathVariable("id") Long id, CarEntity car) {
    logger.info("Received request for updating car with details id :{} and car :{}", id, car);
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

  /**
   * @param id
   * @return deletes car with provided id
   */
  @DeleteMapping("/cars/{id}")
  public ResponseEntity<HttpStatus> deleteCarById(@PathVariable("id") long id) {
    logger.info("Received request to delete car with id :{}", id);
    try {
      carService.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
