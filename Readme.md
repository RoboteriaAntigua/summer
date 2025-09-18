# Summer Framework

A fast and robust framework to rocket-fuel your Spring development.

## Features

* **Create a complete CRUD application with a single command.**
* **Simplify microservices architecture** with modules representing each API.
* **Scale individual APIs** independently.
* Compatible with both **MongoDB and MySQL**.
* **Professional support** available for larger projects.
* A **great starting point for Java beginners**.

## Why Summer?

Imagine you need to create a web application with CRUD operations for 40 tables. How long would that take? With the
Summer framework, you can do it in just **5 minutes**.

> "But won't that create a monolithic API?"

Not at all. Each module can be compiled individually, giving you the flexibility to build and deploy services
independently.

> "What if I only need a small application with a few entities?"

Summer is perfect for that too. It's transparent and easy to modify, allowing you to add new features as your project
grows.

## Temary

* [Create a CRUD with one single command with Mongod (Recomended)](#create-a-crud-module-mongodb)
* [Create a CRUD with one single command (Mysql)](#create-a-crud-module-mysql)
* [Run the app](#run-the-application)
* [Activate or Deactivate Modules](#activate-or-deactivate-modules)
* [Personalize the root folder of the modules](#configure-when-the-modules-will-be-created)

## Prerequisites

<details>
<summary> Expand to see prerequisites</summary>

* MongoDB or MySQL connection string
* Java 17+
* Groovy 3.0+

</details>

# Getting Started

## Create a CRUD Module (MongoDB)

## 1. Run command

The `summer` command creates a new module complete with a controller, service, repository, entity, and DTO. All you need
to do is provide the name of your new module. This should correspond to an existing collection name in your MongoDB
database.

```bash
java summer <ModuleName> [options]
```

**Examples:**

```bash
java summer ExampleModuleName -all
java summer ExistingTableName -all
java summer ExistingCollectionName -all
```

### 2. Command Options

* `-all`: Generate controller, entity, repository, DTO, and service.
* `-c`: Generate only the cont...

<details>
<summary> Expand to see more steps</summary>

### 2. Command Options

* `-all`: Generate controller, entity, repository, DTO, and service.
* `-c`: Generate only the controller.
* `-s`: Generate only the service.
* `-e`: Generate only the entity.

### 3. Start MongoDB

```bash
sudo service mongod start
```

### 4. Define Your Data Structures

With MongoDB, you don't need to worry about migrations. Simply add properties to your Entity and DTO classes as needed.

```java
private String name;
private String anotherField;
```

### Run the application:

```bash
mvn spring-boot:run
```

### Use Your New Endpoints

* **Get All:** `GET http://localhost:8080/api/<moduleName>/index`
* **Create:** `POST http://localhost:8080/api/<moduleName>/store`
* **Get One:** `GET http://localhost:8080/api/<moduleName>/{id}`
* **Update:** `PUT http://localhost:8080/api/<moduleName>/{id}`

</details>
 
------------------------------------------------------------------------------------------------------------------------

<br>
<br>

## Create a CRUD Module (Mysql)

<details>
<summary> Expand to get single steps </summary>

## 1. Add dependencys on pom.xml

 ```xml

<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <scope>runtime</scope>
</dependency>

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## 2. Add configurations for mysql

Application.yml:

```yaml
spring:
  # Activate this for mysql
  #
  datasource:
    url: jdbc:mysql://localhost:3306/spring_test
    username: topo
    password: 123
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.MySQL8Dialect
```

### 3. Remove configurations for mongod (you will not use)

```yaml
#  data:
#    mongodb:
#      # Add the authSource parameter to the end of the URI
#      uri: mongodb://master:123@localhost:27017/summer?authSource=admin
```

## 4. Run the command and make a complete CRUD

The `summer` command creates a new module complete with a controller, service, repository, entity, and DTO. All you need
to do is provide the name of your new module. This should correspond to an existing table name in your mysql
database.

```bash
java summer <ModuleName> [options] -mysql
```

**Examples:**

```bash
java summer ExampleModuleName -all -mysql
java summer ExistingTableName -all -mysql
java summer service_orders -e -mysql
```

### 5. Define Your Data Structures

    Add existing fields in the new DTO and ENTITY

```java
private String name;
private String anotherField;
```

------------------------------------------------------------------------------------------------------------------------

<br>
<br>
### Run the application:

```bash
mvn spring-boot:run
```

### Use Your New Endpoints

* **Get All:** `GET http://localhost:8080/api/<moduleName>/index`
* **Create:** `POST http://localhost:8080/api/<moduleName>/store`
* **Get One:** `GET http://localhost:8080/api/<moduleName>/{id}`
* **Update:** `PUT http://localhost:8080/api/<moduleName>/{id}`

</details>

------------------------------------------------------------------------------------------------------------------------


<br>
<br>

# Activate or Deactivate Modules

This feature allows you to enable or disable endpoints, making it easy to:

* Deploy endpoints to different environments.
* Scale high-traffic endpoints independently...

<details>
<summary> Expand to see more</summary>

* Simplify maintenance with a single deployment for all endpoints.

In your `application.yml` or `application.properties` file, specify which modules are active:

```yaml
modules:
  exampleModule1: true
  exampleModule2: false
  exampleModule3: true
```

</details>

------------------------------------------------------------------------------------------------------------------------

<br>
<br>

# Configure when the modules will be created:

Localice the summerConfig.json, here you can tell to summer when the new modules should be created


<br>
<br>

# Run the application:

```bash
mvn spring-boot:run
```