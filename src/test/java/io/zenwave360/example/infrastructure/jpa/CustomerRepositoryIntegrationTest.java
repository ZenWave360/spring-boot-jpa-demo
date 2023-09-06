package io.zenwave360.example.infrastructure.jpa;

import io.zenwave360.example.core.domain.*;
import io.zenwave360.example.core.outbound.jpa.CustomerRepository;
import java.time.*;
import java.util.HashSet;
import javax.persistence.EntityManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerRepositoryIntegrationTest extends BaseRepositoryIntegrationTest {

  @Autowired EntityManager entityManager;

  @Autowired CustomerRepository customerRepository;

  @Test
  public void findAllTest() {
    var results = customerRepository.findAll();
    Assertions.assertFalse(results.isEmpty());
  }

  @Test
  public void findByIdTest() {
    var id = 1L;
    var customer = customerRepository.findById(id).orElseThrow();
    Assertions.assertTrue(customer.getId() != null);
    Assertions.assertTrue(customer.getVersion() != null);
  }

  @Test
  public void saveTest() {
    Customer customer = new Customer();
    customer.setUsername("aaa");
    customer.setPassword("aaa");
    customer.setEmail("aaa");
    customer.setFirstName("aaa");
    customer.setLastName("aaa");

    // OneToMany addresses owner: true
    var addresses = new Address();
    addresses.setStreet("aaa");
    addresses.setCity("aaa");
    addresses.setCountry("aaa");
    addresses.setZipCode("aaa");
    customer.setAddresses(new HashSet<>());
    customer.getAddresses().add(addresses);

    // Persist aggregate root
    var created = customerRepository.save(customer);

    entityManager.refresh(created); // reloading to get relationships persisted by id
    Assertions.assertTrue(created.getId() != null);
    Assertions.assertTrue(created.getVersion() != null);

    Assertions.assertTrue(customer.getAddresses().stream().allMatch(item -> item.getId() != null));
  }

  @Test
  public void updateTest() {
    var id = 1L;
    var customer = customerRepository.findById(id).orElseThrow();
    customer.setUsername("aaa");
    customer.setPassword("aaa");
    customer.setEmail("aaa");
    customer.setFirstName("aaa");
    customer.setLastName("aaa");

    customer = customerRepository.save(customer);
    Assertions.assertEquals("aaa", customer.getUsername());
    Assertions.assertEquals("aaa", customer.getPassword());
    Assertions.assertEquals("aaa", customer.getEmail());
    Assertions.assertEquals("aaa", customer.getFirstName());
    Assertions.assertEquals("aaa", customer.getLastName());
  }

  @Test
  public void deleteTest() {
    var id = 1L;
    customerRepository.deleteById(id);
    var notFound = customerRepository.findById(id);
    Assertions.assertFalse(notFound.isPresent());
  }
}
