# ZenWave Example

<!-- TOC -->
- [ZenWave Example](#zenwave-example)
- [Install ZenWave SDK](#install-zenwave-sdk)
- [Starting Docker Infrastructure](#starting-docker-infrastructure)
- [Generate Backend Application](#generate-backend-application)
- [JDL To OpenAPI](#jdl-to-openapi)
- [SpringMVC Controllers](#springmvc-controllers)
- [Spring WebTestClient](#spring-webtestclient)
- [JDL To AsyncAPI](#jdl-to-asyncapi)
- [ZenWave Maven Plugin for AsyncAPI](#zenwave-maven-plugin-for-asyncapi)
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
    specFile=src/main/resources/model/model.jdl \
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
    specFile=src/main/resources/model/model.jdl \
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
    jdlFile=src/main/resources/model/model.jdl \
    basePackage=io.zenwave360.example \
    openApiApiPackage=io.zenwave360.example.adapters.web \
    openApiModelPackage=io.zenwave360.example.adapters.web.model \
    openApiModelNameSuffix=DTO \
    targetFolder=.
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
