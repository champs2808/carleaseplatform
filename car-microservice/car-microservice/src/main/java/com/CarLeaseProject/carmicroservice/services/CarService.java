package com.CarLeaseProject.carmicroservice.services;

import com.CarLeaseProject.carmicroservice.model.CarEntity;
import com.CarLeaseProject.carmicroservice.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CarService {

  @Autowired private CarRepository carRepository;

  public List<CarEntity> getAllCars() {
    return carRepository.findAll();
  }

  public Optional<CarEntity> getCarByID(Long id) {
    return carRepository.findById(id);
  }

  public CarEntity getCarByModelAndVersion(String model, String version) {
    return carRepository.findByModelAndVersion(model, version);
  }

  public CarEntity createCar(CarEntity car) {
    if (carRepository.findByModelAndVersion(car.getModel(), car.getVersion()) == null) {
      return carRepository.save(
          new CarEntity(
              car.getMake(),
              car.getModel(),
              car.getVersion(),
              car.getNumberOfDoors(),
              car.getCo2Emission(),
              car.getGrossPrice(),
              car.getNettPrice()));
    }
    return carRepository.findByModelAndVersion(car.getModel(), car.getVersion());
  }

  public CarEntity updateCar(Long id, CarEntity car) {
    Optional<CarEntity> _car = carRepository.findById(id);
    if (_car.isPresent()) {
      CarEntity carEntity = _car.get();
      carEntity.setMake(car.getMake());
      carEntity.setModel(car.getModel());
      carEntity.setVersion(car.getVersion());
      carEntity.setNumberOfDoors(car.getNumberOfDoors());
      carEntity.setCo2Emission(car.getCo2Emission());
      carEntity.setGrossPrice(car.getGrossPrice());
      carEntity.setNettPrice(car.getNettPrice());
      return carRepository.save(carEntity);
    }
    return null;
  }

  @Transactional
  public void deleteById(Long id) {
    carRepository.deleteById(id);
  }
}
