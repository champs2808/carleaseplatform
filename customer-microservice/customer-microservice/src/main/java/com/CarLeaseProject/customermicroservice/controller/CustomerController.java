package com.CarLeaseProject.customermicroservice.controller;

import com.CarLeaseProject.customermicroservice.model.CustomerEntity;
import com.CarLeaseProject.customermicroservice.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")

public class CustomerController {

  @Autowired private CustomerService customerService;

  /**
   *
   * @param emailAddress
   * @return
   */
  @GetMapping("/customers")
  public ResponseEntity<List<CustomerEntity>> getAllCustomers(
      @RequestParam(required = false) String emailAddress) {
    try {
      List<CustomerEntity> customerEntityList = customerService.getAllCustomers(emailAddress);
      if (customerEntityList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(customerEntityList, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   *
   * @param id
   * @return
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<CustomerEntity> getCustomersById(@PathVariable("id") Long id) {
    try {
      Optional<CustomerEntity> customer = customerService.getCustomersById(id);
      if (customer.isPresent()) {
        return new ResponseEntity<>(customer.get(), HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   *
   * @param customer
   * @return
   */
  @PostMapping("/customers")
  public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
    try {
      CustomerEntity customerEntity = customerService.createCustomer(customer);
      return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   *
   * @param email_address
   * @param customer
   * @return
   */
  @PutMapping("/customers/update/{email_address}")
  public ResponseEntity<CustomerEntity> updateCustomer(
      @RequestBody String email_address, CustomerEntity customer) {
    try {
      CustomerEntity customerEntity = customerService.updateCustomer(email_address, customer);
      if (customerEntity != null) {
        return new ResponseEntity<>(customerEntity, HttpStatus.OK);
      } else {
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
      }
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  /**
   *
   * @param email_address
   * @return
   */
  @DeleteMapping("/customers/delete/{email_address}")
  public ResponseEntity<HttpStatus> deleteCustomerByEmailAddress(
      @RequestBody String email_address) {
    try {
      customerService.deleteByEmailAddress(email_address);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   *
   * @param id
   * @return
   */
  @DeleteMapping("/customers/deleteById/{id}")
  public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("id") Long id) {
    try {
      customerService.deleteCustomerById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
