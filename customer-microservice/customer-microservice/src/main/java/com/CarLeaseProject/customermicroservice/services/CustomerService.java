package com.CarLeaseProject.customermicroservice.services;

import com.CarLeaseProject.customermicroservice.repository.CustomerRepository;
import com.CarLeaseProject.customermicroservice.model.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

  @Autowired private CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public List<CustomerEntity> getAllCustomers(String emailAddress) {
    if (emailAddress == null) {
      return customerRepository.findAll();
    } else {
      return List.of(customerRepository.findByEmailAddress(emailAddress));
    }
  }

  public Optional<CustomerEntity> getCustomersById(Long id) {
    return customerRepository.findById(id);
  }

  public CustomerEntity createCustomer(CustomerEntity customer) {
    if (customerRepository.findByEmailAddress(customer.getEmailAddress()) == null) {
      CustomerEntity customerEntity =
          customerRepository.save(
              new CustomerEntity(
                  customer.getName(),
                  customer.getStreet(),
                  customer.getHouse_number(),
                  customer.getZipcode(),
                  customer.getPlace(),
                  customer.getEmailAddress(),
                  customer.getPhone_number()));
      return customerEntity;
    } else {
      return customerRepository.findByEmailAddress(customer.getEmailAddress());
    }
  }

  public CustomerEntity updateCustomer(String email_address, CustomerEntity customer) {

    CustomerEntity customerEntity = customerRepository.findByEmailAddress(email_address);
    if (customerEntity != null) {
      if (customer.getName() != null) {
        customerEntity.setName(customer.getName());
      }
      if (customer.getStreet() != null) {
        customerEntity.setStreet(customer.getStreet());
      }
      if (customer.getHouse_number() != null) {
        customerEntity.setHouse_number(customer.getHouse_number());
      }
      if (customer.getZipcode() != null) {
        customerEntity.setZipcode(customer.getZipcode());
      }
      if (customer.getPlace() != null) {
        customerEntity.setPlace(customer.getPlace());
      }
      if (customer.getEmailAddress() != null) {
        customerEntity.setEmailAddress(email_address);
      }
      if (customer.getPhone_number() != null) {
        customerEntity.setPhone_number(customer.getPhone_number());
      }
      customerRepository.save(customerEntity);
    }
    return customerEntity;
  }

  @Transactional
  public void deleteByEmailAddress(String email_address) {
    customerRepository.deleteByEmailAddress(email_address);
  }

  @Transactional
  public void deleteCustomerById(Long id) {
    customerRepository.deleteById(id);
  }
}
