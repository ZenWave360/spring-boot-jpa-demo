# ZenWave Example

<!-- TOC -->
* [ZenWave Example](#zenwave-example)
* [Install ZenWave SDK](#install-zenwave-sdk)
* [Starting Docker Infrastructure](#starting-docker-infrastructure)
* [Generate Backend Application](#generate-backend-application)
* [JDL To OpenAPI](#jdl-to-openapi)
* [SpringMVC Controllers](#springmvc-controllers)
* [Spring WebTestClient](#spring-webtestclient)
* [JDL To AsyncAPI](#jdl-to-asyncapi)
* [ZenWave Maven Plugin for AsyncAPI](#zenwave-maven-plugin-for-asyncapi)
<!-- TOC -->

# Install ZenWave SDK

```shell
jbang alias add --fresh --name=zw release@zenwave360/zenwave-sdk
```

or if you prefer to use the latest **snapshot** versions:

```shell
jbang alias add --fresh --name=zw snapshots@zenwave360/zenwave-sdk
```
Print help with a list of all available plugins:

```shell
jbang zw -h list
```

# Starting Docker Infrastructure

```shell
cd src/main/docker
docker-compose -f all-dependencies.yml up -d
```

# Generate Backend Application

```shell
jbang zw -p io.zenwave360.sdk.plugins.JDLBackendApplicationDefaultPlugin \
    specFile=src/main/resources/model/orders-model.jdl \
    basePackage=io.zenwave360.example \
    persistence=jpa \
    databaseType=mariadb \
    style=imperative \
    targetFolder=. \
    --force
```

# JDL To OpenAPI

Generate OpenAPI definition from JDL entities:

- Component Schemas for entities, plain and paginated lists
- CRUD operations for entities

```shell
jbang zw -p io.zenwave360.sdk.plugins.JDLToOpenAPIPlugin \
    specFile=src/main/resources/model/orders-model.jdl \
    idType=integer \
    idTypeFormat=int64 \
    targetFile=src/main/resources/model/openapi.yml
```
Generate SpringMVC interfaces from OpenAPI:

```shell
mvn clean generate-sources
```
# SpringMVC Controllers

Generate new SpringMVC controllers from OpenAPI:

```shell
jbang zw -p io.zenwave360.sdk.plugins.JDLOpenAPIControllersPlugin \
    specFile=src/main/resources/model/openapi.yml \
    jdlFile=src/main/resources/model/orders-model.jdl \
    basePackage=io.zenwave360.example \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    targetFolder=.
```

Edit `TODO` tags in the generated controllers to connect API with business logic:

```java
package io.zenwave360.example.adapters.web;

@Override
public ResponseEntity<CustomerDTO> createCustomer(CustomerDTO reqBody) {
    CustomerInput customerInput = mapper.asCustomerInput(reqBody);
    Customer customer = null; // TODO: customerUseCases.createCustomer(customerInput);
    CustomerDTO responseDTO = mapper.asCustomerDTO(customer);
    return ResponseEntity.status(201).body(responseDTO);
}
```

# Spring WebTestClient

Generates test for SpringMVC or Spring WebFlux using WebTestClient based on OpenAPI specification.

```shell
jbang zw -p io.zenwave360.sdk.plugins.SpringWebTestClientPlugin \
    specFile=src/main/resources/model/openapi.yml \
    targetFolder=src/test/java \
    testsPackage=io.zenwave360.example.adapters.web \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    groupBy=service
```

Generate Customer CRUD Integration Test:

```shell
jbang zw -p io.zenwave360.sdk.plugins.SpringWebTestClientPlugin \
    specFile=src/main/resources/model/openapi.yml \
    targetFolder=src/test/java \
    testsPackage=io.zenwave360.example.adapters.web \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    groupBy=businessFlow \
    businessFlowTestName=Customer_CRUD_IT \
    operationIds=createCustomer,getCustomer,updateCustomer,deleteCustomer
```

Generate CustomerOrder CRUD Integration Test:

```shell
jbang zw -p io.zenwave360.sdk.plugins.SpringWebTestClientPlugin \
    specFile=src/main/resources/model/openapi.yml \
    targetFolder=src/test/java \
    testsPackage=io.zenwave360.example.adapters.web \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    groupBy=businessFlow \
    businessFlowTestName=CustomerOrder_CRUD_IT \
    operationIds=createCustomerOrder,getCustomerOrder,updateCustomerOrder,deleteCustomerOrder
```

# JDL To AsyncAPI

Generate AsyncAPI definition from JDL entities:

- One channel for each entity update events
- Messages and payloads for each entity Create/Update/Delete events (AVRO and AsyncAPI schema)

```shell
jbang zw -p io.zenwave360.sdk.plugins.JDLToAsyncAPIPlugin \
    includeCommands=false \
    specFile=src/main/resources/model/orders-model.jdl \
    idType=integer \
    idTypeFormat=int64 \
    annotations=aggregate \
    payloadStyle=event \
    targetFile=src/main/resources/model/asyncapi.yml
```

# ZenWave Maven Plugin for AsyncAPI

Enable ZenWave Maven plugins for AsyncAPI editing pom.xml:

```xml
<plugin>
    <groupId>io.github.zenwave360.zenwave-sdk</groupId>
    <artifactId>zenwave-sdk-maven-plugin</artifactId>
    <version>${zenwave.version}</version>
    <configuration>
        <inputSpec>${pom.basedir}/src/main/resources/model/asyncapi.yml</inputSpec>
        <skip>true</skip><!-- set to false to generate sources -->
```

Generate Spring Cloud Streams DTOs, business interfaces and producer implementations from AsyncAPI:

```shell
mvn clean generate-sources
```

Follow instructions: 

[Spring Cloud Streams Producer: Using generated code to produce messages](https://zenwave360.github.io/Event-Driven-Architectures/AsyncAPI-Code-Generator#spring-cloud-streams-producer-using-generated-code-to-produce-messages)
