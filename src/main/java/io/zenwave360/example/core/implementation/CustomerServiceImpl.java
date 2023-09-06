package io.zenwave360.example.core.implementation;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.jpa.*;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/** Service Implementation for managing [Customer]. */
@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService {

  private final Logger log = LoggerFactory.getLogger(getClass());

  private final CustomerMapper customerMapper = Mappers.getMapper(CustomerMapper.class);
  private final CustomerRepository customerRepository;

  /** Constructor. */
  public CustomerServiceImpl(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
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
}
