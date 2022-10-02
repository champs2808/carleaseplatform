package com.CarLeaseProject.carmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CarMicroserviceApplication {

  public static void main(String[] args) {
    SpringApplication.run(CarMicroserviceApplication.class, args);
  }
}
