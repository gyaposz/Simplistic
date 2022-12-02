# simplistic-context-hierarchy
### Description
![example workflow](https://github.com/gyaposz/Simplistic/actions/workflows/maven.yml/badge.svg)

This module shows how an application level context can be separated of from web layer specific context.
* A package named `application` can be thought of as root context. It may contain database and/or service layer related
beans.
* A `web` package has also been introduced. This is the servlet level context. It has visibility of `application`
context as well as the content of its own context.
* `application` context cannot see beans in `web` context. A good example is `CommonService`. If you try to modify the
`@Autowired(required = false)` setting of its constructor parameter called `ViewBean` the deployment of the WAR file
will fail.
* On the other hand, `TestController` works fine with both `CommonService` and `ViewBean` at the same time.

Content is similar to examples in https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#mvc-servlet-context-hierarchy
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

In your favourite browser open `http://localhost:8080/simplistic-context-hierarchy/application`

or

`http://localhost:8080/simplistic-context-hierarchy/web`

#### Integration Testing
Corresponding integration test(s) file can be found under `test/java/...` directory.

#### Unit Testing
Corresponding unit test file(s) can be found under `test/java/...` directory.
