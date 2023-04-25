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
@Table(name = "customer_order")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class CustomerOrder implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Version private Integer version;

  @Column(name = "date")
  private Instant date;

  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  @Embedded
  @AttributeOverride(name = "address", column = @Column(name = "shipping_details_address"))
  @AttributeOverride(name = "phone", column = @Column(name = "shipping_details_phone"))
  private OrderShippingDetails shippingDetails;

  @OneToMany(mappedBy = "customerOrder", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<OrderedItem> orderedItems = new HashSet<>();

  @Column(name = "payment_details_id")
  private Long paymentDetailsId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "payment_details_id", updatable = false, insertable = false)
  private PaymentDetails paymentDetails;

  @Column(name = "customer_id")
  private Long customerId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", updatable = false, insertable = false)
  private Customer customer;

  public Long getId() {
    return id;
  }

  public CustomerOrder withId(Long id) {
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

  public CustomerOrder withDate(Instant date) {
    this.date = date;
    return this;
  }

  public CustomerOrder withStatus(OrderStatus status) {
    this.status = status;
    return this;
  }

  public CustomerOrder withShippingDetails(OrderShippingDetails shippingDetails) {
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

  public OrderShippingDetails getShippingDetails() {
    return shippingDetails;
  }

  public void setShippingDetails(OrderShippingDetails shippingDetails) {
    this.shippingDetails = shippingDetails;
  }

  public Set<OrderedItem> getOrderedItems() {
    return orderedItems;
  }

  public void setOrderedItems(Set<OrderedItem> orderedItems) {
    this.orderedItems = orderedItems;
  }

  public Long getPaymentDetailsId() {
    return paymentDetailsId;
  }

  public void setPaymentDetailsId(Long paymentDetailsId) {
    this.paymentDetailsId = paymentDetailsId;
  }

  public PaymentDetails getPaymentDetails() {
    return paymentDetails;
  }

  public void setPaymentDetails(PaymentDetails paymentDetails) {
    this.paymentDetails = paymentDetails;
  }

  public Long getCustomerId() {
    return customerId;
  }

  public void setCustomerId(Long customerId) {
    this.customerId = customerId;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
