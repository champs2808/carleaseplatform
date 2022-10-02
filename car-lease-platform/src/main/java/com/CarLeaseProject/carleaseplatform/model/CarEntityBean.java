package com.CarLeaseProject.carleaseplatform.model;

public class CarEntityBean {

    String make;
    String model;
    String version;
    Integer numberOfDoors;
    Double co2Emission;
    Double grossPrice;

    @Override
    public String toString() {
        return "CarEntityBean{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", version='" + version + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", co2Emission=" + co2Emission +
                ", grossPrice=" + grossPrice +
                ", nettPrice=" + nettPrice +
                '}';
    }



    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(Integer numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public Double getCo2Emission() {
        return co2Emission;
    }

    public void setCo2Emission(Double co2Emission) {
        this.co2Emission = co2Emission;
    }

    public Double getGrossPrice() {
        return grossPrice;
    }

    public void setGrossPrice(Double grossPrice) {
        this.grossPrice = grossPrice;
    }

    public Double getNettPrice() {
        return nettPrice;
    }

    public void setNettPrice(Double nettPrice) {
        this.nettPrice = nettPrice;
    }

    Double nettPrice;
}
