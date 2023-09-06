package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class AddressInput implements Serializable {

  private Long id;

  private Integer version;

  @NotNull
  @Size(min = 3, max = 250)
  private String street;

  @NotNull
  @Size(min = 3, max = 250)
  private String city;

  @NotNull
  @Size(min = 3, max = 250)
  private String country;

  @NotNull
  @Size(min = 3, max = 250)
  private String zipCode;

  private CustomerInput customer;

  public Long getId() {
    return id;
  }

  public AddressInput withId(Long id) {
    this.id = id;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVersion() {
    return version;
  }

  public void setVersion(Integer version) {
    this.version = version;
  }

  public AddressInput withStreet(String street) {
    this.street = street;
    return this;
  }

  public AddressInput withCity(String city) {
    this.city = city;
    return this;
  }

  public AddressInput withCountry(String country) {
    this.country = country;
    return this;
  }

  public AddressInput withZipCode(String zipCode) {
    this.zipCode = zipCode;
    return this;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  public CustomerInput getCustomer() {
    return customer;
  }

  public void setCustomer(CustomerInput customer) {
    this.customer = customer;
  }
}
