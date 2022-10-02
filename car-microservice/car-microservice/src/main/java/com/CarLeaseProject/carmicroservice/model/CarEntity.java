package com.CarLeaseProject.carmicroservice.model;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class CarEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "MAKE")
  private String make;

  @Column(name = "MODEL")
  private String model;

  @Column(name = "VERSION")
  private String version;

  @Column(name = "NUMBER_OF_DOORS")
  private Integer numberOfDoors;

  @Column(name = "CO2_EMISSION")
  private Double co2Emission;

  @Column(name = "GROSS_PRICE")
  private Double grossPrice;

  @Column(name = "NETT_PRICE")
  private Double nettPrice;

  private CarEntity() {}

  public CarEntity(
      String make,
      String model,
      String version,
      Integer numberOfDoors,
      Double co2Emission,
      Double grossPrice,
      Double nettPrice) {
    super();
    this.id = id;
    this.make = make;
    this.model = model;
    this.version = version;
    this.numberOfDoors = numberOfDoors;
    this.co2Emission = co2Emission;
    this.grossPrice = grossPrice;
    this.nettPrice = nettPrice;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public double getCo2Emission() {
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

  @Override
  public String toString() {
    return "CarEntity{"
        + "id="
        + id
        + ", make='"
        + make
        + '\''
        + ", model='"
        + model
        + '\''
        + ", version="
        + version
        + ", numberOfDoors="
        + numberOfDoors
        + ", co2Emission="
        + co2Emission
        + ", grossPrice="
        + grossPrice
        + ", nettPrice="
        + nettPrice
        + '}';
  }
}
