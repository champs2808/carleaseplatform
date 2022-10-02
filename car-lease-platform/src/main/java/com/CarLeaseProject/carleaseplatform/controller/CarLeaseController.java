package com.CarLeaseProject.carleaseplatform.controller;

import com.CarLeaseProject.carleaseplatform.model.CarEntityBean;
import com.CarLeaseProject.carleaseplatform.CarLeaseProxy;
import com.CarLeaseProject.carleaseplatform.utilities.CarLeaseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CarLeaseController {
  @Autowired
  private CarLeaseProxy proxy;

  Logger logger = LoggerFactory.getLogger(CarLeaseController.class);

  /**
   *
   * @param mileage
   * @param duration
   * @param interestRate
   * @param model
   * @param version
   * @return
   */
  @GetMapping("/calculatelease")
  public ResponseEntity<Double> getLeaseRate(
      @RequestParam Double mileage,
      Integer duration,
      Float interestRate,
      String model,
      String version) {
  try{
    List<CarEntityBean> response = proxy.getCarByModelAndVersion(model, version);
    if(response==null)
    {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(CarLeaseUtility.calculateCarLease(mileage,duration,interestRate,response.get(0).getNettPrice()),HttpStatus.OK);
    }
  catch (Exception exception)
  {
    logger.info("Exception occured",exception);
    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
  }
  }
}
