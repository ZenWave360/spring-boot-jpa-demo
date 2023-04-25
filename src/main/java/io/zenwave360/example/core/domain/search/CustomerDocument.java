package io.zenwave360.example.core.domain.search;

import java.io.Serializable;
import javax.validation.constraints.*;
import org.springframework.data.elasticsearch.annotations.Document;

/** */
@Document(indexName = "customer")
public class CustomerDocument implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String username;
  private String password;
  private String email;
  private String firstName;
  private String lastName;

  public CustomerDocument withUsername(String username) {
    this.username = username;
    return this;
  }

  public CustomerDocument withPassword(String password) {
    this.password = password;
    return this;
  }

  public CustomerDocument withEmail(String email) {
    this.email = email;
    return this;
  }

  public CustomerDocument withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public CustomerDocument withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public Long getId() {
    return id;
  }

  public CustomerDocument withId(Long id) {
    this.id = id;
    return this;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
}
