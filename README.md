# Spring Boot 3.x Price API

**A Spring Boot 3.x Price api to manage online-shop prices**
 
## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/downloads/#java17)
- [Maven 3](https://maven.apache.org)
- 
## Running the application locally

There are several ways to run a Spring Boot application on your local machine.

* First one, you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

- **Using maven** <br/>``` mvn spring-boot:run```


- **From jar file**
  Create a jar file using '**mvn clean install**' command and then execute
  <br/>```java -jar target/price-api-1.0.0-SNAPSHOT.jar```


- **Directly from IDE**
  <br/>```Right click on PriceApplication.java and click on 'Run' option```
  <br/><br/>

> **Note:** By default spring boot application starts on port number 8080. If port 8080 is occupied in your system then you can change the port number by uncommenting and updating the **server.port** property inside the **application.properties** file that is available inside the **src > main > resources** folder.

<br/>
