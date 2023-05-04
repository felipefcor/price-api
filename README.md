# Spring Boot 3.x Price API

**A Spring Boot 3.x Price api to manage online-shop prices**
 
## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

- First one, you can use the maven wrapper. Depending of your OS you could run in one way or another:
    - Linux
      <br/>First clean using '**./mvnw clean install**' and after run:
      <br/>```./mvnw spring-boot:run```
    - Windows
      <br/>First clean using '**mvnw.cmd clean install**' and after run:
      <br/>```./mvnw spring-boot:run```

- Second one, you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:
  <br/>First clean using '**mvn clean install**' and after run:
  <br/>``` mvn spring-boot:run```

- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/price-api-1.0.0-SNAPSHOT.jar```


- **Directly from IDE**
  <br/>```Right click on PriceApplication.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.properties** file that is available inside the **src > main > resources** folder.



## Using the application locally

When the project is running you could do petitions to the api through two options:
- **Swagger** 
  <br/> [Swagger link](http://localhost:8080/swagger-ui/index.htm)
  <br/> [Swagger api petition](http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T10%3A00%3A00Z)


- **Postman**  With the collections you could find in the root directory


- **Curl**
    ```` curl -X 'GET' \
  'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T10%3A00%3A00Z' \
  -H 'accept: application/json'````
