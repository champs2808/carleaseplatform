package com.CarLeaseProject.customermicroservice.services;

import com.CarLeaseProject.customermicroservice.model.CustomerEntity;
import com.CarLeaseProject.customermicroservice.repository.CustomerRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;
@DataJpaTest
class CustomerServiceTest {

    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    private CustomerEntity customer;
//    @Autowired
//    CustomerEntity customer;

    @BeforeEach
    void setUp() {
         this.customer=new CustomerEntity("Garvit Gupta","Sudama Nagar",2092,452009,"indore"
                ,"garvit2808@gmail.com",9479722920L);
        customerRepository.save(customer);
    }

    @Test
    void getAllCustomers() {
        Mockito.when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        List<CustomerEntity> customerEntityList=customerService.getAllCustomers(null);
        Assertions.assertEquals(1,customerEntityList.size());
    }

    @Test
    void getCustomersById() {
    }

    @Test
    void createCustomer() {
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteByEmailAddress() {
    }

    @Test
    void deleteCustomerById() {
    }
}