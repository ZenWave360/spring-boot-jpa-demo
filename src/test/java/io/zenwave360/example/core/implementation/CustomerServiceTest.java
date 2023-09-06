package io.zenwave360.example.core.implementation;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import io.zenwave360.example.config.*;
import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.implementation.mappers.*;
import io.zenwave360.example.core.inbound.*;
import io.zenwave360.example.core.inbound.dtos.*;
import io.zenwave360.example.core.outbound.jpa.*;
import io.zenwave360.example.infrastructure.jpa.inmemory.*;
import java.time.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;

/** Acceptance Test for CustomerService. */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerServiceTest {

  private final Logger log = LoggerFactory.getLogger(getClass());

  InMemoryTestsManualContext context = InMemoryTestsManualContext.INSTANCE;
  CustomerServiceImpl customerService = context.customerService();

  CustomerRepositoryInMemory customerRepository = context.customerRepository();

  @BeforeEach
  void setUp() {
    customerRepository.clear();
    customerRepository.save(new Customer());
  }

  // Customer

  @Test
  @Order(01)
  void testCRUDCustomer() {
    var input = new CustomerInput();
    // TODO fill input data
    // input.setUsername("aaa");
    // input.setPassword("aaa");
    // input.setEmail("aaa");
    // input.setFirstName("aaa");
    // input.setLastName("aaa");
    var customer = customerService.createCustomer(input);
    assertNotNull(customer.getId());
    assertTrue(customerRepository.containsEntity(customer));

    var id = customer.getId();
    var customerUpdate = new CustomerInput();
    // TODO fill update data
    // customerUpdate.setUsername("aaa");
    // customerUpdate.setPassword("aaa");
    // customerUpdate.setEmail("aaa");
    // customerUpdate.setFirstName("aaa");
    // customerUpdate.setLastName("aaa");
    assertTrue(customerRepository.containsKey(id));
    var customerUpdated = customerService.updateCustomer(id, customerUpdate);
    assertTrue(customerUpdated.isPresent());
    assertTrue(customerRepository.containsEntity(customerUpdated.get()));

    assertTrue(customerRepository.containsKey(id));
    customerService.deleteCustomer(id);
    assertFalse(customerRepository.containsKey(id));
  }

  @Test
  @Order(02)
  void testCreateCustomer() {
    var input = new CustomerInput();
    // TODO fill input data
    // input.setUsername("aaa");
    // input.setPassword("aaa");
    // input.setEmail("aaa");
    // input.setFirstName("aaa");
    // input.setLastName("aaa");
    var customer = customerService.createCustomer(input);
    assertNotNull(customer.getId());
    assertTrue(customerRepository.containsEntity(customer));
  }

  @Test
  @Order(03)
  void testUpdateCustomer() {
    var id = 0L; // TODO fill id
    var input = new CustomerInput();
    // TODO fill input data
    // input.setUsername("aaa");
    // input.setPassword("aaa");
    // input.setEmail("aaa");
    // input.setFirstName("aaa");
    // input.setLastName("aaa");
    assertTrue(customerRepository.containsKey(id));
    var customer = customerService.updateCustomer(id, input);
    assertTrue(customer.isPresent());
    assertTrue(customerRepository.containsEntity(customer.get()));
  }

  @Test
  @Order(04)
  void testListCustomers() {
    var results = customerService.listCustomers(PageRequest.of(0, 10));
    assertNotNull(results);
  }

  @Test
  @Order(06)
  void testGetCustomer() {
    var id = 0L; // TODO fill id
    var customer = customerService.getCustomer(id);
    assertTrue(customer.isPresent());
  }

  @Test
  @Order(07)
  void testDeleteCustomer() {
    var id = 0L; // TODO fill id
    assertTrue(customerRepository.containsKey(id));
    customerService.deleteCustomer(id);
    assertFalse(customerRepository.containsKey(id));
  }
}
