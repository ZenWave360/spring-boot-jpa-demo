package io.zenwave360.example.config;

import io.zenwave360.example.core.implementation.*;

public class InMemoryTestsManualContext extends InMemoryTestsConfig {

  public static final InMemoryTestsManualContext INSTANCE = new InMemoryTestsManualContext();

  public CustomerServiceImpl customerService() {
    return new CustomerServiceImpl(customerRepository());
  }
}
