package com.CarLeaseProject.customermicroservice.model;

import javax.persistence.*;

@Entity
@Table(name = "CUSTOMER")
public class CustomerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "STREET")
  private String street;

  @Column(name = "HOUSE_NUMBER")
  private Integer house_number;

  @Column(name = "ZIPCODE")
  private Integer zipcode;

  @Column(name = "PLACE")
  private String place;

  @Column(name = "EMAIL_ADDRESS")
  private String emailAddress;

  @Column(name = "PHONE_NUMBER")
  private Long phone_number;

  private CustomerEntity() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public int getHouse_number() {
    return house_number;
  }

  public void setHouse_number(Integer house_number) {
    this.house_number = house_number;
  }

  public Integer getZipcode() {
    return zipcode;
  }

  public void setZipcode(Integer zipcode) {
    this.zipcode = zipcode;
  }

  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  public Long getPhone_number() {
    return phone_number;
  }

  public void setPhone_number(Long phone_number) {
    this.phone_number = phone_number;
  }

  public CustomerEntity(
          String name,
          String street,
          Integer house_number,
          Integer zipcode,
          String place,
          String emailAddress,
          Long phone_number) {
    super();
    this.id = id;
    this.name = name;
    this.street = street;
    this.house_number = house_number;
    this.zipcode = zipcode;
    this.place = place;
    this.emailAddress = emailAddress;
    this.phone_number = phone_number;
  }

  @Override
  public String toString() {
    return "CustomerEntity{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", street='"
        + street
        + '\''
        + ", house_number="
        + house_number
        + ", zipcode="
        + zipcode
        + ", place='"
        + place
        + '\''
        + ", email_address='"
        + emailAddress
        + '\''
        + ", phone_number="
        + phone_number
        + '}';
  }
}
