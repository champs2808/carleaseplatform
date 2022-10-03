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

* customer-microservice -- This microservice is a REST API used by broker to maintain customer database. Broker can perform CRUD operation on the repository.In this microservice intial data is loaded on run-time using data.sql file.
This microservice is configured to run on port-8000 and can be accessed(on localhost) via swagger-ui as well using URL http://localhost:8000/swagger-ui.html. This microservice has following mappings-

GET ```/api/customers``` Fetches all customer records present in Database.
It accepts emailAdress as request parameter and returns record with provided email address, when emailAddress is blank , it retreives all the records.
 
Request Parameter- emailAddress
Response- 200 OK content 
Content-List of Customers
 
POST ```/api/customers``` Creates a customer entry in Database.
 
Sample request body-
 
{
   "name": "Garvit Gupta",
   "street": "Sudama Nagar",
   "house_number": 2092,
   "zipcode": 452009,
   "place": "Indore",
   "emailAddress": "garvit@email.com",
   "phone_number": 9691857064
 }
  
 Response-  200	OK 
 Content- Customer
 GET ```/api/customers/{id}```  Fetches record with provided customer id.
 
 Request Parameter- id
 Reponse-200 OK
 
 DELETE ```/api/customers/delete/{emailAddress}``` Deletes customer with provided emailAddress.
 
 Request Parameter- emailAddress
 Reponse-200 OK (No content)
 
 DELETE ```/api/customers/deleteById/{id}```  Deletes customer with provided id.
 
 Request Parameter- id
 Reponse-200 OK(No content)
 
 
PUT ```/api/customers/update/{emailAddress}``` - Updates record with provided emailAddress, only updates record which are provided in request body.

 Request Parameter- id , fields to update
 Reponse-200 OK
 Content- Updated Customer record
 
 * car-microservice -- This microservice is a REST API used by company employees to maintain car database. Employyes can perform CRUD operation on the repository.In this microservice intial data is loaded on run-time using data.sql file.
This microservice is configured to run on port-8004 and can be accessed(on localhost) via swagger-ui as well using URL http://localhost:8004/swagger-ui.html. This microservice has following mappings-
 
 GET ```/api/cars``` Fetches all car record present in car database.
 
 Response-200 Ok
 Content- List of Cars
 
POST ```/api/carscreateCar``` Creates car entry in Database.

 Sample Request Body
 {
    "make": "Volkswagen",
    "model": "T-Roc",
    "version": "TSI-2",
    "numberOfDoors": 4,
    "co2Emission": 220,
    "grossPrice": 55000,
    "nettPrice": 65000
  }
 
 Response- 200 OK
 Content- Car
 
 GET ```/api/cars/{id}``` Fetches car with provided id.
 
 Request parameter-id
 Response- 200 OK 
 Content-Car
 
 PUT ```/api/cars/{id}``` Updates record with provided id, only updates record which are provided in request body.
 
 Request param-id, field to update
 Response 200 OK 
 Content- Car
 
 DELETE ```/api/cars/{id}```
 
 Request Parameter- id
 
 Reponse-200 OK(No content)
 
 GET ```/api/cars/fetchByModelandVersion``` Fetches car with provided model and version.
 
 Request parameter-model, version
 Response- 200 OK 
 Content-Car
 
 
  * car-lease-service -- This microservice is a REST API used by broker to calculate leaserate. EThis microservice is configured to run on port-8008 and can be accessed(on localhost) via swagger-ui as well using URL http://localhost:8008/swagger-ui.html. This microservice has following mappings-
  
  GET ```/api/calculatelease```
  
  Request Parameter-duration,interestRate,mileage,model,version
  Response- 200 OK
  Content- leaserate
  
  
 
 
 






