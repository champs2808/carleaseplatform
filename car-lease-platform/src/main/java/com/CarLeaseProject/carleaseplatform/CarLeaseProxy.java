package com.CarLeaseProject.carleaseplatform;


import com.CarLeaseProject.carleaseplatform.model.CarEntityBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(name="car-service")
public interface CarLeaseProxy {
    @RequestMapping("api/cars/fetchByModelandVersion")
    List<CarEntityBean> getCarByModelAndVersion(@RequestParam String model, @RequestParam  String version);
}
