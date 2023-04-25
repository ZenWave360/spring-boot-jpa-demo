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
* Integration tests for the {@link CustomerOrderApi} REST controller.
*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CustomerOrderApiIT extends BaseWebTestClientTest {



    /**
    * Test:  for CustomerOrders.
    */
    @Test
    @Order(0)
    public void testSearchCustomerOrders_200() {
        CustomerOrderSearchCriteriaDTO requestBody = new CustomerOrderSearchCriteriaDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setStatus(null);
        requestBody.setDateFrom(null);
        requestBody.setDateTo(null);
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(POST).uri(uriBuilder -> uriBuilder.path("/api/customer-orders/search").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
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
            .jsonPath("$.content[0].date").isNotEmpty()
            .jsonPath("$.content[0].status").isNotEmpty()
            .jsonPath("$.content[0].shippingDetails").isNotEmpty()
            .jsonPath("$.content[0].orderedItems").isNotEmpty()
            .jsonPath("$.content[0].paymentDetailsId").isNotEmpty()
            .jsonPath("$.content[0].paymentDetails").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrders.
    */
    @Test
    @Order(0)
    public void testListCustomerOrders_200() {
        var page = "";
        var limit = "";
        var sort = "";

        webTestClient.method(GET).uri(uriBuilder -> uriBuilder.path("/api/customer-orders").queryParam("page", page).queryParam("limit", limit).queryParam("sort", sort).build(page, limit, sort))
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
            .jsonPath("$.content[0].date").isNotEmpty()
            .jsonPath("$.content[0].status").isNotEmpty()
            .jsonPath("$.content[0].shippingDetails").isNotEmpty()
            .jsonPath("$.content[0].orderedItems").isNotEmpty()
            .jsonPath("$.content[0].paymentDetailsId").isNotEmpty()
            .jsonPath("$.content[0].paymentDetails").isNotEmpty()
            .jsonPath("$.content[0].customerId").isNotEmpty()
            .jsonPath("$.content[0].customer").isNotEmpty();
    }

    /**
    * Test:  for CustomerOrder.
    */
    @Test
    @Order(0)
    public void testCreateCustomerOrder_201() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setDate(null);
        requestBody.setStatus(null);
        requestBody.setShippingDetails(new OrderShippingDetailsDTO());
        requestBody.getShippingDetails().setAddress("aaa");
        requestBody.getShippingDetails().setPhone("aaa");
        requestBody.setOrderedItems(new java.util.ArrayList<>());
        requestBody.getOrderedItems().get(0).setId(1L);
        requestBody.getOrderedItems().get(0).setVersion(1);
        requestBody.getOrderedItems().get(0).setCatalogItemId(1L);
        requestBody.getOrderedItems().get(0).setName("aaa");
        requestBody.getOrderedItems().get(0).setPrice(BigDecimal.valueOf(0));
        requestBody.getOrderedItems().get(0).setQuantity(1);
        requestBody.setPaymentDetailsId(null);
        requestBody.setPaymentDetails(new PaymentDetailsDTO());
        requestBody.getPaymentDetails().setId(1L);
        requestBody.getPaymentDetails().setVersion(1);
        requestBody.getPaymentDetails().setCreditCardNumber("aaa");
        requestBody.getPaymentDetails().setCardHolderName("aaa");
        requestBody.getPaymentDetails().setCustomerId(1L);
        requestBody.getPaymentDetails().setCustomer(new CustomerDTO());
        requestBody.setCustomerId(null);
        requestBody.setCustomer(new CustomerDTO());
        requestBody.getCustomer().setId(1L);
        requestBody.getCustomer().setVersion(1);
        requestBody.getCustomer().setUsername("aaa");
        requestBody.getCustomer().setPassword("aaa");
        requestBody.getCustomer().setEmail("aaa");
        requestBody.getCustomer().setFirstName("aaa");
        requestBody.getCustomer().setLastName("aaa");

        webTestClient.method(POST).uri("/api/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty()
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
    * Test:  for CustomerOrder.
    */
    @Test
    @Order(0)
    public void testGetCustomerOrder_200() {
        var id = "";

        webTestClient.method(GET).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty()
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
    * Test:  for CustomerOrder.
    */
    @Test
    @Order(0)
    public void testUpdateCustomerOrder_200() {
        CustomerOrderDTO requestBody = new CustomerOrderDTO();
        requestBody.setId(null);
        requestBody.setVersion(null);
        requestBody.setDate(null);
        requestBody.setStatus(null);
        requestBody.setShippingDetails(new OrderShippingDetailsDTO());
        requestBody.getShippingDetails().setAddress("aaa");
        requestBody.getShippingDetails().setPhone("aaa");
        requestBody.setOrderedItems(new java.util.ArrayList<>());
        requestBody.getOrderedItems().get(0).setId(1L);
        requestBody.getOrderedItems().get(0).setVersion(1);
        requestBody.getOrderedItems().get(0).setCatalogItemId(1L);
        requestBody.getOrderedItems().get(0).setName("aaa");
        requestBody.getOrderedItems().get(0).setPrice(BigDecimal.valueOf(0));
        requestBody.getOrderedItems().get(0).setQuantity(1);
        requestBody.setPaymentDetailsId(null);
        requestBody.setPaymentDetails(new PaymentDetailsDTO());
        requestBody.getPaymentDetails().setId(1L);
        requestBody.getPaymentDetails().setVersion(1);
        requestBody.getPaymentDetails().setCreditCardNumber("aaa");
        requestBody.getPaymentDetails().setCardHolderName("aaa");
        requestBody.getPaymentDetails().setCustomerId(1L);
        requestBody.getPaymentDetails().setCustomer(new CustomerDTO());
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

        webTestClient.method(PUT).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(requestBody)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .expectBody()
            .jsonPath("$.id").isNotEmpty()
            .jsonPath("$.version").isNotEmpty()
            .jsonPath("$.date").isNotEmpty()
            .jsonPath("$.status").isNotEmpty()
            .jsonPath("$.shippingDetails").isNotEmpty()
            .jsonPath("$.shippingDetails.address").isNotEmpty()
            .jsonPath("$.shippingDetails.phone").isNotEmpty()
            .jsonPath("$.orderedItems").isNotEmpty()
            .jsonPath("$.orderedItems").isArray()
            .jsonPath("$.orderedItems[0].id").isNotEmpty()
            .jsonPath("$.orderedItems[0].version").isNotEmpty()
            .jsonPath("$.orderedItems[0].catalogItemId").isNotEmpty()
            .jsonPath("$.orderedItems[0].name").isNotEmpty()
            .jsonPath("$.orderedItems[0].price").isNotEmpty()
            .jsonPath("$.orderedItems[0].quantity").isNotEmpty()
            .jsonPath("$.paymentDetailsId").isNotEmpty()
            .jsonPath("$.paymentDetails").isNotEmpty()
            .jsonPath("$.paymentDetails.id").isNotEmpty()
            .jsonPath("$.paymentDetails.version").isNotEmpty()
            .jsonPath("$.paymentDetails.creditCardNumber").isNotEmpty()
            .jsonPath("$.paymentDetails.cardHolderName").isNotEmpty()
            .jsonPath("$.paymentDetails.customerId").isNotEmpty()
            .jsonPath("$.paymentDetails.customer").isNotEmpty()
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
    * Test:  for CustomerOrder deleted.
    */
    @Test
    @Order(0)
    public void testDeleteCustomerOrder_204() {
        var id = "";

        webTestClient.method(DELETE).uri("/api/customer-orders/{id}", id)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);
    }

}
