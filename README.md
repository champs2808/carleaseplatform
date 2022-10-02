# Car-lease Platform API

This is a microservice based Java / Maven / Spring Boot (version 2.7.4) application that allows users to maintain cars,customers and calculate car leaserate.

There are mutiple microservices in this application 

* customer-microservice
* car-microservice
* car-lease-platform
* eureka-naming-server

## How to Run these services-

* Clone this repository 
* Make sure you are using JDK 17 and Maven 3.x
* You can build individual microservices using ```mvn clean install```
* Once successfully built, you can run the services by starting each microservice using run option on main(Application) class or by creating a run configuration.

## About the Service

The service is a basic Car-lease Platform API service. It uses an in-memory database (H2) to store the data. All microservices except eureka-naming-server registers itself on eureka-server and gets invoked when a REST call is made to that service.

Each microservice can have a res controller which can either be invoked using swagger-ui or using postman.Each microservice can be replicated on multiple ports. Details about individual microservice is as follows-

*customer-microservice -- This microservice is a REST API used by broker to maintain customer database. Broker can perform CRUD operation on the repository.In this microservice intial data is loaded on run-time using data.sql file.
This microservice is configured to run on port-8000 and can be accessed(on localhost) via swagger-ui as well using URL http://localhost:8000/swagger-ui.html.This microservice has following mappings-

```/api/customers``` Fetches all customer records present in Database.



