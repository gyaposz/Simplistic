# simplistic-mvc-initializer2
### Description
![example workflow](https://github.com/gyaposz/Simplistic/actions/workflows/maven.yml/badge.svg)

This module is a very limited Spring Web MVC project:
* It contains `ReflectController` class (being a `RestController`) that answers the `Long` value back it receives as
  request parameter.
* It contains `MainWebApplicationInitializer` class that extends `WebApplicationInitializer` and gives you the full
power to configure the servlet and deploy it programmatically.

That is enough to start our very first Spring Web MVC example.

It differs from [simplistic-mvc-initializer](https://github.com/gyaposz/Simplistic/tree/main/simplistic-mvc-initializer)
that servlet configuration and registration must be done by you. `WebMvcConfigurer` is not even necessary since
component scan is taken care of by the Initializer.

Content is similar to examples in https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-servlet
### Building
#### Requirements
* Java 17
* Maven 3

#### Build steps
In order to start build, run integration test and create the war file simply
`mvn clean install`

### Testing
#### Manual Testing
For manual testing download Apache Tomcat 10 (please note that Apache Tomcat 9 will not work) deploy the created war
file into Tomcat's webapps directory, start Tomcat the usual way (`/bin/startup.sh` or `/bin/startup.bat`).

In your favourite browser open `http://localhost:8080/simplistic-mvc-initializer2/10`

#### Integration Testing
Corresponding integration test file can be found under `test/java/...` directory.
