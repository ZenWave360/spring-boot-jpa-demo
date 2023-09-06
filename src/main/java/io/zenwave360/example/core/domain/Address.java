package io.zenwave360.example.core.domain;

import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/** */
@Entity
@Table(name = "address")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Address implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Version private Integer version;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "street", nullable = false, length = 250)
  private String street;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "city", nullable = false, length = 250)
  private String city;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "country", nullable = false, length = 250)
  private String country;

  @NotNull
  @Size(min = 3, max = 250)
  @Column(name = "zip_code", nullable = false, length = 250)
  private String zipCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  public Long getId() {
    return id;
  }

  public Address withId(Long id) {
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

  public Address withStreet(String street) {
    this.street = street;
    return this;
  }

  public Address withCity(String city) {
    this.city = city;
    return this;
  }

  public Address withCountry(String country) {
    this.country = country;
    return this;
  }

  public Address withZipCode(String zipCode) {
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

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
