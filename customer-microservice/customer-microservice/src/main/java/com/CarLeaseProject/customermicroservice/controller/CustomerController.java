package com.CarLeaseProject.customermicroservice.controller;

import com.CarLeaseProject.customermicroservice.model.CustomerEntity;
import com.CarLeaseProject.customermicroservice.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {

  @Autowired private CustomerService customerService;

  Logger logger = LoggerFactory.getLogger(CustomerController.class);

  /**
   * @param emailAddress
   * @return all customer when emailAddress is not provided, customer with specified email address
   *     when emailAddress is provided, no content when emailAddress is not present in DB
   */
  @GetMapping("/customers")
  public ResponseEntity<List<CustomerEntity>> getAllCustomers(
      @RequestParam(required = false) String emailAddress) {
    logger.info("Received request for fetching all customers with email :{}", emailAddress);
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
   * @param id
   * @return customer with provided id
   */
  @GetMapping("/customers/{id}")
  public ResponseEntity<CustomerEntity> getCustomersById(@PathVariable("id") Long id) {
    logger.info("Received request for fetching customer with id :{}", id);
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
   * @param customer
   * @return creates customer with specified details
   */
  @PostMapping("/customers")
  public ResponseEntity<CustomerEntity> createCustomer(@RequestBody CustomerEntity customer) {
    logger.info("Received request for creating customer with details :{}", customer);
    try {
      CustomerEntity customerEntity = customerService.createCustomer(customer);
      return new ResponseEntity<>(customerEntity, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

  /**
   * @param email_Address
   * @param customer
   * @return updates specific customer
   */
  @PutMapping("/customers/update/{emailAddress}")
  public ResponseEntity<CustomerEntity> updateCustomer(
      @RequestBody String email_Address, CustomerEntity customer) {
    logger.info(
        "Received request for updating customer with details emailAddress:{}, customer:{}",
        email_Address,
        customer);
    try {
      CustomerEntity customerEntity = customerService.updateCustomer(email_Address, customer);
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
   * @param emailAddress
   * @return delete customer with specified emailAddress
   */
  @Transactional
  @DeleteMapping("/customers/delete/{emailAddress}")
  public ResponseEntity<HttpStatus> deleteCustomerByEmailAddress(
      @PathVariable String emailAddress) {
    logger.info("Received request for deleting customer with emailAddress :{}", emailAddress);
    try {
      customerService.deleteByEmailAddress(emailAddress);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  /**
   * @param id
   * @return delete customer with provided id
   */
  @Transactional
  @DeleteMapping("/customers/deleteById/{id}")
  public ResponseEntity<HttpStatus> deleteCustomerById(@PathVariable("id") Long id) {
    logger.info("Received request for deleting customer with id :{}", id);
    try {
      customerService.deleteCustomerById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
