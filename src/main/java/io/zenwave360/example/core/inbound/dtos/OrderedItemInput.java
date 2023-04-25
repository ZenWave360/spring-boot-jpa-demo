package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class OrderedItemInput implements Serializable {

  private Long id;

  private Integer version;

  private Long catalogItemId;

  @NotNull
  @Size(min = 3, max = 250)
  private String name;

  @NotNull private BigDecimal price;

  private Integer quantity;

  private CustomerOrderInput customerOrder;

  public Long getId() {
    return id;
  }

  public OrderedItemInput withId(Long id) {
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

  public OrderedItemInput withCatalogItemId(Long catalogItemId) {
    this.catalogItemId = catalogItemId;
    return this;
  }

  public OrderedItemInput withName(String name) {
    this.name = name;
    return this;
  }

  public OrderedItemInput withPrice(BigDecimal price) {
    this.price = price;
    return this;
  }

  public OrderedItemInput withQuantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  public Long getCatalogItemId() {
    return catalogItemId;
  }

  public void setCatalogItemId(Long catalogItemId) {
    this.catalogItemId = catalogItemId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public CustomerOrderInput getCustomerOrder() {
    return customerOrder;
  }

  public void setCustomerOrder(CustomerOrderInput customerOrder) {
    this.customerOrder = customerOrder;
  }
}
