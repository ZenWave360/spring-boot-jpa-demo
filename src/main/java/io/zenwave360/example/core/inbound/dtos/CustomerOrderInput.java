package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class CustomerOrderInput implements Serializable {

  private Long id;

  private Integer version;

  private Instant date;

  private OrderStatus status;

  private OrderShippingDetailsInput shippingDetails;

  private Set<OrderedItemInput> orderedItems = new HashSet<>();

  private Long paymentDetailsId;

  private Long customerId;

  public Long getId() {
    return id;
  }

  public CustomerOrderInput withId(Long id) {
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

  public CustomerOrderInput withDate(Instant date) {
    this.date = date;
    return this;
  }

  public CustomerOrderInput withStatus(OrderStatus status) {
    this.status = status;
    return this;
  }

  public CustomerOrderInput withShippingDetails(OrderShippingDetailsInput shippingDetails) {
    this.shippingDetails = shippingDetails;
    return this;
  }

  public Instant getDate() {
    return date;
  }

  public void setDate(Instant date) {
    this.date = date;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public void setStatus(OrderStatus status) {
    this.status = status;
  }

  public OrderShippingDetailsInput getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(OrderShippingDetailsInput shippingDetails) {
    this.shippingDetails = shippingDetails;
  }

  public Set<OrderedItemInput> getOrderedItems() {
    return orderedItems;
  }

  public void setOrderedItems(Set<OrderedItemInput> orderedItems) {
    this.orderedItems = orderedItems;
  }

  public Long getPaymentDetailsId() {
    return paymentDetailsId;
  }

  public void setPaymentDetailsId(Long paymentDetailsId) {
    this.paymentDetailsId = paymentDetailsId;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
