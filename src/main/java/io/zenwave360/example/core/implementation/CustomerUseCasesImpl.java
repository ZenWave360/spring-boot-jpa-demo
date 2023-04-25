package io.zenwave360.example.core.implementation;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.jpa.*;
import io.zenwave360.example.core.outbound.search.*;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Customer, PaymentDetails, ShippingDetails]. */
@Service
@Transactional(readOnly = true)
public class CustomerUseCasesImpl implements CustomerUseCases {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
  private final CustomerRepository customerRepository;
  private final CustomerSearchRepository customerSearchRepository;

  private final PaymentDetailsMapper paymentDetailsMapper = Mappers.getMapper(PaymentDetailsMapper.class);
  private final PaymentDetailsRepository paymentDetailsRepository;

  private final ShippingDetailsMapper shippingDetailsMapper = Mappers.getMapper(ShippingDetailsMapper.class);
  private final ShippingDetailsRepository shippingDetailsRepository;

  /** Constructor. */
  public CustomerUseCasesImpl(
      CustomerRepository customerRepository,
      CustomerSearchRepository customerSearchRepository,
      PaymentDetailsRepository paymentDetailsRepository,
      ShippingDetailsRepository shippingDetailsRepository) {
    this.customerRepository = customerRepository;
    this.customerSearchRepository = customerSearchRepository;
    this.paymentDetailsRepository = paymentDetailsRepository;

    this.shippingDetailsRepository = shippingDetailsRepository;
  }

  // Customer

  @Override
  public Customer createCustomer(CustomerInput input) {
    log.debug("Request to save Customer: {}", input);
    var customer = customerMapper.update(new Customer(), input);
    customer = customerRepository.save(customer);
    // TODO: you may need to reload the entity here to fetch all the relationships
    return customer;
  }

  @Override
  public Optional<Customer> updateCustomer(Long id, CustomerInput input) {
    log.debug("Request to update Customer: {}", input);
    var customer = customerRepository.findById(id);
    customer = customer.map(existingcustomer -> customerMapper.update(existingcustomer, input));
    // saving is unnecessary: https://vladmihalcea.com/best-spring-data-jparepository/
    return customer;
  }

  @Override
  public Page<Customer> listCustomers(Pageable pageable) {
    log.debug("Request list of Customers: {}", pageable);
    return customerRepository.findAll(pageable);
  }

  @Override
  public Page<Customer> searchCustomers(CustomerCriteria criteria, Pageable pageable) {
    log.debug("Request to search Customers: {} - {}", criteria, pageable);
    // TODO implement this search by criteria
    return customerRepository.findAll(pageable);
  }

  @Override
  public Optional<Customer> getCustomer(Long id) {
    log.debug("Request to get Customer : {}", id);
    return customerRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = false)
  public void deleteCustomer(Long id) {
    log.debug("Request to delete Customer : {}", id);
    customerRepository.deleteById(id);
  }

  // PaymentDetails

  @Override
  public PaymentDetails createPaymentDetails(PaymentDetailsInput input) {
    log.debug("Request to save PaymentDetails: {}", input);
    var paymentDetails = paymentDetailsMapper.update(new PaymentDetails(), input);
    paymentDetails = paymentDetailsRepository.save(paymentDetails);
    // TODO: you may need to reload the entity here to fetch all the relationships
    return paymentDetails;
  }

  @Override
  public Optional<PaymentDetails> updatePaymentDetails(Long id, PaymentDetailsInput input) {
    log.debug("Request to update PaymentDetails: {}", input);
    var paymentDetails = paymentDetailsRepository.findById(id);
    paymentDetails = paymentDetails.map(existingpaymentDetails -> paymentDetailsMapper.update(existingpaymentDetails, input));
    // saving is unnecessary: https://vladmihalcea.com/best-spring-data-jparepository/
    return paymentDetails;
  }

  @Override
  public Page<PaymentDetails> listPaymentDetails(Pageable pageable) {
    log.debug("Request list of PaymentDetails: {}", pageable);
    return paymentDetailsRepository.findAll(pageable);
  }

  @Override
  public Optional<PaymentDetails> getPaymentDetails(Long id) {
    log.debug("Request to get PaymentDetails : {}", id);
    return paymentDetailsRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = false)
  public void deletePaymentDetails(Long id) {
    log.debug("Request to delete PaymentDetails : {}", id);
    paymentDetailsRepository.deleteById(id);
  }

  // ShippingDetails

  @Override
  public ShippingDetails createShippingDetails(ShippingDetailsInput input) {
    log.debug("Request to save ShippingDetails: {}", input);
    var shippingDetails = shippingDetailsMapper.update(new ShippingDetails(), input);
    shippingDetails = shippingDetailsRepository.save(shippingDetails);
    // TODO: you may need to reload the entity here to fetch all the relationships
    return shippingDetails;
  }

  @Override
  public Optional<ShippingDetails> updateShippingDetails(Long id, ShippingDetailsInput input) {
    log.debug("Request to update ShippingDetails: {}", input);
    var shippingDetails = shippingDetailsRepository.findById(id);
    shippingDetails = shippingDetails.map(existingshippingDetails -> shippingDetailsMapper.update(existingshippingDetails, input));
    // saving is unnecessary: https://vladmihalcea.com/best-spring-data-jparepository/
    return shippingDetails;
  }

  @Override
  public Page<ShippingDetails> listShippingDetails(Pageable pageable) {
    log.debug("Request list of ShippingDetails: {}", pageable);
    return shippingDetailsRepository.findAll(pageable);
  }

  @Override
  public Optional<ShippingDetails> getShippingDetails(Long id) {
    log.debug("Request to get ShippingDetails : {}", id);
    return shippingDetailsRepository.findById(id);
  }

  @Override
  @Transactional(readOnly = false)
  public void deleteShippingDetails(Long id) {
    log.debug("Request to delete ShippingDetails : {}", id);
    shippingDetailsRepository.deleteById(id);
  }
}
