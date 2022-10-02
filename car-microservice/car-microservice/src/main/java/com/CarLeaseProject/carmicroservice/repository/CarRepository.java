package com.CarLeaseProject.carmicroservice.repository;


import com.CarLeaseProject.carmicroservice.model.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<CarEntity,Long> {

    List<CarEntity> findAll();

    List<CarEntity> findByModelAndVersion(String model, String version);


}

