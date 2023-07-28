# SpringBoot-with-H2-Database

## Project Setup Documentation - Spring Boot with H2 Database

This documentation provides a step-by-step guide on setting up a Spring Boot project with an H2 in-memory database for managing Employee entities. The project will include REST API endpoints to perform CRUD (Create, Read, Update, Delete) operations on Employee data.

### Prerequisites:
- Java Development Kit (JDK) version 17 or later installed on your system.
- A text editor or an Integrated Development Environment (IDE) of your choice.
- Apache Maven (latest version) installed on your system (optional, as some IDEs come with Maven integration).

### Step 1: Create a New Spring Boot Project
1. Open your preferred IDE or text editor.
2. Create a new Spring Boot project with the following settings:
   - Project type: Maven Project
   - Group: com.masai
   - Artifact: H2dataBaseApi
   - Dependencies: Select Spring Web, Spring Data JPA, H2 Database, and Lombok dependencies.

### Step 2: Configure Application Properties
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

### Step 3: Create Entity Class
1. Create a new Java class named `Employee` in the `com.masai.h2.Model` package.
2. Define the `Employee` entity with the following attributes:
   - `id` (Long)
   - `firstName` (String)
   - `lastName` (String)
   - `email` (String, unique)
   - `designation` (String)
   - `salary` (double)

### Step 4: Create Repository Interface
1. Create a new Java interface named `EmployeeRepository` in the `com.masai.h2.Repo` package.
2. Declare the `EmployeeRepository` interface to extend `JpaRepository<Employee, Long>`.

### Step 5: Create Service Interface and Implementation
1. Create a new Java interface named `EmployeeService` in the `com.masai.h2.Service` package.
2. Declare the following methods in the `EmployeeService` interface:
   - `getAllEmployees()`: Retrieve a list of all employees.
   - `getEmployeeById(Long id)`: Retrieve an employee by their ID.
   - `createEmployee(Employee employee)`: Create a new employee.
   - `updateEmployee(Long id, Employee updatedEmployee)`: Update an existing employee.
   - `deleteEmployeeById(Long id)`: Delete an employee by their ID.

3. Create a new Java class named `EmployeeServiceImpl` in the `com.masai.h2.Service` package.
4. Implement the `EmployeeService` interface in the `EmployeeServiceImpl` class.

### Step 6: Create Controller
1. Create a new Java class named `EmployeeController` in the `com.masai.h2.controller` package.
2. Define the `EmployeeController` class with the following REST API endpoints:
   - `GET /employees`: Retrieve a list of all employees.
   - `GET /employees/{id}`: Retrieve an employee by their ID.
   - `POST /employees`: Create a new employee.
   - `PUT /employees/{id}`: Update an existing employee by their ID.
   - `DELETE /employees/{id}`: Delete an employee by their ID.

### Step 7: Build and Run the Project
1. Use Maven or your IDE's build functionality to build the project.
2. Once the build is successful, run the Spring Boot application. The application will start, and the H2 database will be initialized in memory.

### Step 8: Test the API
1. Use tools like Postman or cURL to test the REST API endpoints.
2. Perform CRUD operations on Employee data using the API.

### Step 9 (Optional): Accessing H2 Console
- If you want to access the H2 database console, go to `http://localhost:8080/h2-console` (assuming your application is running on the default port 8080).
- Use the JDBC URL `jdbc:h2:mem:testdb`, and the username `sa` (with an empty password) to connect to the H2 console.

Congratulations! You have successfully set up a Spring Boot project with H2 database, created REST API endpoints, and can perform CRUD operations on Employee data. You can further customize and enhance the project based on your requirements.

Remember to handle security and authentication appropriately if you plan to deploy the project to a production environment.

Note: This documentation assumes that you have a basic understanding of Spring Boot, Java, and RESTful web services.