package io.zenwave360.example.adapters.web;

import io.zenwave360.example.adapters.web.*;
import io.zenwave360.example.adapters.web.model.*;
import io.zenwave360.example.adapters.web.BaseWebTestClientTest;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.springframework.http.HttpMethod.*;

/**
* Integration tests for the {@link CustomerApi} REST controller.
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerApiIT extends BaseWebTestClientTest {



    /**
    * Test:  for Customers.
    */
    @Test
    @Order(0)
    public void testSearchCustomers_200() {
        CustomerCriteriaDTO requestBody = new CustomerCriteriaDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setUsername(null);
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(POST).uri(uriBuilder -> uriBuilder.path("/api/customers/search").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].username").isNotEmpty()
            .jsonPath("$.content[0].password").isNotEmpty()
            .jsonPath("$.content[0].email").isNotEmpty()
            .jsonPath("$.content[0].firstName").isNotEmpty()
            .jsonPath("$.content[0].lastName").isNotEmpty();
    }

    /**
    * Test:  for Customers.
    */
    @Test
    @Order(0)
    public void testListCustomers_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/customers").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].username").isNotEmpty()
            .jsonPath("$.content[0].password").isNotEmpty()
            .jsonPath("$.content[0].email").isNotEmpty()
            .jsonPath("$.content[0].firstName").isNotEmpty()
            .jsonPath("$.content[0].lastName").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    @Order(0)
    public void testCreateCustomer_201() {
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setUsername(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);

        webTestClient.method(POST).uri("/api/customers")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.username").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    @Order(0)
    public void testGetCustomer_200() {
        var id = "";

        webTestClient.method(GET).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.username").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty();
    }

    /**
    * Test:  for Customer.
    */
    @Test
    @Order(0)
    public void testUpdateCustomer_200() {
        CustomerDTO requestBody = new CustomerDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setUsername(null);
        requestBody.setPassword(null);
        requestBody.setEmail(null);
        requestBody.setFirstName(null);
        requestBody.setLastName(null);
        var id = "";

        webTestClient.method(PUT).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.username").isNotEmpty()
            .jsonPath("$.password").isNotEmpty()
            .jsonPath("$.email").isNotEmpty()
            .jsonPath("$.firstName").isNotEmpty()
            .jsonPath("$.lastName").isNotEmpty();
    }

    /**
    * Test:  for Customer deleted.
    */
    @Test
    @Order(0)
    public void testDeleteCustomer_204() {
        var id = "";

        webTestClient.method(DELETE).uri("/api/customers/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

    /**
    * Test:  for PaymentDetails.
    */
    @Test
    @Order(0)
    public void testListPaymentDetails_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/payment-details").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].creditCardNumber").isNotEmpty()
            .jsonPath("$.content[0].cardHolderName").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty();
    }

    /**
    * Test:  for PaymentDetails.
    */
    @Test
    @Order(0)
    public void testCreatePaymentDetails_201() {
        PaymentDetailsDTO requestBody = new PaymentDetailsDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setCreditCardNumber(null);
        requestBody.setCardHolderName(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(1L);
        requestBody.getCustomer().setVersion(1);
        requestBody.getCustomer().setUsername("aaa");
        requestBody.getCustomer().setPassword("aaa");
        requestBody.getCustomer().setEmail("aaa");
        requestBody.getCustomer().setFirstName("aaa");
        requestBody.getCustomer().setLastName("aaa");

        webTestClient.method(POST).uri("/api/payment-details")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.creditCardNumber").isNotEmpty()
            .jsonPath("$.cardHolderName").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for PaymentDetails.
    */
    @Test
    @Order(0)
    public void testGetPaymentDetails_200() {
        var id = "";

        webTestClient.method(GET).uri("/api/payment-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.creditCardNumber").isNotEmpty()
            .jsonPath("$.cardHolderName").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for PaymentDetails.
    */
    @Test
    @Order(0)
    public void testUpdatePaymentDetails_200() {
        PaymentDetailsDTO requestBody = new PaymentDetailsDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setCreditCardNumber(null);
        requestBody.setCardHolderName(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(1L);
        requestBody.getCustomer().setVersion(1);
        requestBody.getCustomer().setUsername("aaa");
        requestBody.getCustomer().setPassword("aaa");
        requestBody.getCustomer().setEmail("aaa");
        requestBody.getCustomer().setFirstName("aaa");
        requestBody.getCustomer().setLastName("aaa");
        var id = "";

        webTestClient.method(PUT).uri("/api/payment-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.creditCardNumber").isNotEmpty()
            .jsonPath("$.cardHolderName").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for PaymentDetails deleted.
    */
    @Test
    @Order(0)
    public void testDeletePaymentDetails_204() {
        var id = "";

        webTestClient.method(DELETE).uri("/api/payment-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

    /**
    * Test:  for ShippingDetails.
    */
    @Test
    @Order(0)
    public void testListShippingDetails_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/shipping-details").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.number").isNotEmpty()
            .jsonPath("$.numberOfElements").isNotEmpty()
            .jsonPath("$.size").isNotEmpty()
            .jsonPath("$.totalElements").isNotEmpty()
            .jsonPath("$.totalPages").isNotEmpty()
            .jsonPath("$.content").isNotEmpty()
            .jsonPath("$.content").isArray()
            .jsonPath("$.content[0].id").isNotEmpty()
            .jsonPath("$.content[0].version").isNotEmpty()
            .jsonPath("$.content[0].address").isNotEmpty()
            .jsonPath("$.content[0].phone").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty();
    }

    /**
    * Test:  for ShippingDetails.
    */
    @Test
    @Order(0)
    public void testCreateShippingDetails_201() {
        ShippingDetailsDTO requestBody = new ShippingDetailsDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setAddress(null);
        requestBody.setPhone(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(1L);
        requestBody.getCustomer().setVersion(1);
        requestBody.getCustomer().setUsername("aaa");
        requestBody.getCustomer().setPassword("aaa");
        requestBody.getCustomer().setEmail("aaa");
        requestBody.getCustomer().setFirstName("aaa");
        requestBody.getCustomer().setLastName("aaa");

        webTestClient.method(POST).uri("/api/shipping-details")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.address").isNotEmpty()
            .jsonPath("$.phone").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for ShippingDetails.
    */
    @Test
    @Order(0)
    public void testGetShippingDetails_200() {
        var id = "";

        webTestClient.method(GET).uri("/api/shipping-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.address").isNotEmpty()
            .jsonPath("$.phone").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for ShippingDetails.
    */
    @Test
    @Order(0)
    public void testUpdateShippingDetails_200() {
        ShippingDetailsDTO requestBody = new ShippingDetailsDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setAddress(null);
        requestBody.setPhone(null);
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(1L);
        requestBody.getCustomer().setVersion(1);
        requestBody.getCustomer().setUsername("aaa");
        requestBody.getCustomer().setPassword("aaa");
        requestBody.getCustomer().setEmail("aaa");
        requestBody.getCustomer().setFirstName("aaa");
        requestBody.getCustomer().setLastName("aaa");
        var id = "";

        webTestClient.method(PUT).uri("/api/shipping-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.address").isNotEmpty()
            .jsonPath("$.phone").isNotEmpty()
            .jsonPath("$.customerId").isNotEmpty()
            .jsonPath("$.customer").isNotEmpty()
            .jsonPath("$.customer.id").isNotEmpty()
            .jsonPath("$.customer.version").isNotEmpty()
            .jsonPath("$.customer.username").isNotEmpty()
            .jsonPath("$.customer.password").isNotEmpty()
            .jsonPath("$.customer.email").isNotEmpty()
            .jsonPath("$.customer.firstName").isNotEmpty()
            .jsonPath("$.customer.lastName").isNotEmpty();
    }

    /**
    * Test:  for ShippingDetails deleted.
    */
    @Test
    @Order(0)
    public void testDeleteShippingDetails_204() {
        var id = "";

        webTestClient.method(DELETE).uri("/api/shipping-details/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

}
