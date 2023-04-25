package io.zenwave360.example.core.inbound.dtos;

import io.zenwave360.example.core.domain.*;
import java.io.Serializable;
import java.math.*;
import java.time.*;
import java.util.*;
import javax.validation.constraints.*;

/** */
public class PaymentDetailsInput implements Serializable {

  private Long id;

  private Integer version;

  private String creditCardNumber;

  private String cardHolderName;

  private Long customerId;

  public Long getId() {
    return id;
  }

  public PaymentDetailsInput withId(Long id) {
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

  public PaymentDetailsInput withCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
    return this;
  }

  public PaymentDetailsInput withCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
    return this;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getCardHolderName() {
    return cardHolderName;
  }

  public void setCardHolderName(String cardHolderName) {
    this.cardHolderName = cardHolderName;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }
}
