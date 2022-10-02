package com.CarLeaseProject.customermicroservice.repository;

import com.CarLeaseProject.customermicroservice.model.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {

    List<CustomerEntity> findAll();
    CustomerEntity findByEmailAddress(String email_address);
    List <CustomerEntity> deleteByEmailAddress(String email_address);

}
