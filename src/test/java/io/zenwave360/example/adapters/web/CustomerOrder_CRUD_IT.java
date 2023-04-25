package io.zenwave360.example.adapters.web;

import io.zenwave360.example.adapters.web.*;
import io.zenwave360.example.adapters.web.model.*;
import io.zenwave360.example.adapters.web.BaseWebTestClientTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.math.BigDecimal;

import static org.springframework.http.HttpMethod.*;

/**
* Business Flow Test for: createCustomerOrder, getCustomerOrder, updateCustomerOrder, deleteCustomerOrder.
*/
public class CustomerOrder_CRUD_IT extends BaseWebTestClientTest {

    /**
    * Business Flow Test for: createCustomerOrder, getCustomerOrder, updateCustomerOrder, deleteCustomerOrder.
    */
    @Test
    public void testCustomerOrder_CRUD_IT() {
        // createCustomerOrder: 
        CustomerOrderDTO customerOrderRequestBody0 = new CustomerOrderDTO();
        customerOrderRequestBody0.setId(null);
        customerOrderRequestBody0.setVersion(null);
        customerOrderRequestBody0.setDate(null);
        customerOrderRequestBody0.setStatus(null);
        customerOrderRequestBody0.setShippingDetails(new OrderShippingDetailsDTO());
        customerOrderRequestBody0.getShippingDetails().setAddress("aaa");
        customerOrderRequestBody0.getShippingDetails().setPhone("aaa");
        customerOrderRequestBody0.setOrderedItems(new java.util.ArrayList<>());
        customerOrderRequestBody0.getOrderedItems().get(0).setId(1L);
        customerOrderRequestBody0.getOrderedItems().get(0).setVersion(1);
        customerOrderRequestBody0.getOrderedItems().get(0).setCatalogItemId(1L);
        customerOrderRequestBody0.getOrderedItems().get(0).setName("aaa");
        customerOrderRequestBody0.getOrderedItems().get(0).setPrice(BigDecimal.valueOf(0));
        customerOrderRequestBody0.getOrderedItems().get(0).setQuantity(1);
        customerOrderRequestBody0.setPaymentDetailsId(null);
        customerOrderRequestBody0.setPaymentDetails(new PaymentDetailsDTO());
        customerOrderRequestBody0.getPaymentDetails().setId(1L);
        customerOrderRequestBody0.getPaymentDetails().setVersion(1);
        customerOrderRequestBody0.getPaymentDetails().setCreditCardNumber("aaa");
        customerOrderRequestBody0.getPaymentDetails().setCardHolderName("aaa");
        customerOrderRequestBody0.getPaymentDetails().setCustomerId(1L);
        customerOrderRequestBody0.getPaymentDetails().setCustomer(new CustomerDTO());
        customerOrderRequestBody0.setCustomerId(null);
        customerOrderRequestBody0.setCustomer(new CustomerDTO());
        customerOrderRequestBody0.getCustomer().setId(1L);
        customerOrderRequestBody0.getCustomer().setVersion(1);
        customerOrderRequestBody0.getCustomer().setUsername("aaa");
        customerOrderRequestBody0.getCustomer().setPassword("aaa");
        customerOrderRequestBody0.getCustomer().setEmail("aaa");
        customerOrderRequestBody0.getCustomer().setFirstName("aaa");
        customerOrderRequestBody0.getCustomer().setLastName("aaa");

        var createCustomerOrderResponse0 = webTestClient.method(POST).uri("/api/customer-orders")
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerOrderRequestBody0)
            .exchange()
            .expectStatus().isEqualTo(201)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // getCustomerOrder: 
        var id1 = "";

        var getCustomerOrderResponse1 = webTestClient.method(GET).uri("/api/customer-orders/{id}", id1)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // updateCustomerOrder: 
        CustomerOrderDTO customerOrderRequestBody2 = new CustomerOrderDTO();
        customerOrderRequestBody2.setId(null);
        customerOrderRequestBody2.setVersion(null);
        customerOrderRequestBody2.setDate(null);
        customerOrderRequestBody2.setStatus(null);
        customerOrderRequestBody2.setShippingDetails(new OrderShippingDetailsDTO());
        customerOrderRequestBody2.getShippingDetails().setAddress("aaa");
        customerOrderRequestBody2.getShippingDetails().setPhone("aaa");
        customerOrderRequestBody2.setOrderedItems(new java.util.ArrayList<>());
        customerOrderRequestBody2.getOrderedItems().get(0).setId(1L);
        customerOrderRequestBody2.getOrderedItems().get(0).setVersion(1);
        customerOrderRequestBody2.getOrderedItems().get(0).setCatalogItemId(1L);
        customerOrderRequestBody2.getOrderedItems().get(0).setName("aaa");
        customerOrderRequestBody2.getOrderedItems().get(0).setPrice(BigDecimal.valueOf(0));
        customerOrderRequestBody2.getOrderedItems().get(0).setQuantity(1);
        customerOrderRequestBody2.setPaymentDetailsId(null);
        customerOrderRequestBody2.setPaymentDetails(new PaymentDetailsDTO());
        customerOrderRequestBody2.getPaymentDetails().setId(1L);
        customerOrderRequestBody2.getPaymentDetails().setVersion(1);
        customerOrderRequestBody2.getPaymentDetails().setCreditCardNumber("aaa");
        customerOrderRequestBody2.getPaymentDetails().setCardHolderName("aaa");
        customerOrderRequestBody2.getPaymentDetails().setCustomerId(1L);
        customerOrderRequestBody2.getPaymentDetails().setCustomer(new CustomerDTO());
        customerOrderRequestBody2.setCustomerId(null);
        customerOrderRequestBody2.setCustomer(new CustomerDTO());
        customerOrderRequestBody2.getCustomer().setId(1L);
        customerOrderRequestBody2.getCustomer().setVersion(1);
        customerOrderRequestBody2.getCustomer().setUsername("aaa");
        customerOrderRequestBody2.getCustomer().setPassword("aaa");
        customerOrderRequestBody2.getCustomer().setEmail("aaa");
        customerOrderRequestBody2.getCustomer().setFirstName("aaa");
        customerOrderRequestBody2.getCustomer().setLastName("aaa");
        var id2 = "";

        var updateCustomerOrderResponse2 = webTestClient.method(PUT).uri("/api/customer-orders/{id}", id2)
            .accept(MediaType.APPLICATION_JSON)
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue(customerOrderRequestBody2)
            .exchange()
            .expectStatus().isEqualTo(200)
            .expectHeader().contentType(MediaType.APPLICATION_JSON)
            .returnResult(CustomerOrderDTO.class);

    
        // deleteCustomerOrder: 
        var id3 = "";

        webTestClient.method(DELETE).uri("/api/customer-orders/{id}", id3)
            .accept(MediaType.APPLICATION_JSON)
            .exchange()
            .expectStatus().isEqualTo(204);

    
    }


}
