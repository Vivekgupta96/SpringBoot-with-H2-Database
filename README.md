# SpringBoot-with-H2-Database

## Project Setup Documentation - Spring Boot with H2 Database

This documentation provides a step-by-step guide on setting up a Spring Boot project with an H2 in-memory database for managing Employee entities. The project will include REST API endpoints to perform CRUD (Create, Read, Update, Delete) operations on Employee data.

### Prerequisites:
- Java Development Kit (JDK) version 17 or later installed on your system.
- A text editor or an Integrated Development Environment (IDE) of your choice.
- Apache Maven (latest version) installed on your system (optional, as some IDEs come with Maven integration).


### Configure Application Properties
1. Locate the `application.properties` (or `application.yml`) file in your project's resource folder.
2. Add the following configuration properties to the file:
   ```
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true

   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show_sql=true
   ```
###  REST API endpoints:
   - `GET /employees`: Retrieve a list of all employees.
   - `GET /employees/{id}`: Retrieve an employee by their ID.
   - `POST /employees`: Create a new employee.
   - `PUT /employees/{id}`: Update an existing employee by their ID.
   - `DELETE /employees/{id}`: Delete an employee by their ID.

###  Build and Run the Project
1. Use Maven or your IDE's build functionality to build the project.
2. Once the build is successful, run the Spring Boot application. The application will start, and the H2 database will be initialized in memory.

###  Test the API
1. Use tools like Postman or cURL to test the REST API endpoints.
2. Perform CRUD operations on Employee data using the API.

###  Accessing H2 Console
- If you want to access the H2 database console, go to `http://localhost:8080/h2-console` (assuming your application is running on the default port 8080).
- Use the JDBC URL `jdbc:h2:mem:testdb`, and the username `sa` (with an empty password) to connect to the H2 console.

