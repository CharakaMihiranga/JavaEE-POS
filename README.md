# Java EE POS System

## Overview

The Java EE POS System is a robust Point of Sale (POS) backend solution that manages orders, customers, and inventory. Built using Java EE technologies, it includes servlets, JSON processing, JNDI for database connectivity, and MySQL for data storage.

## Features

- **Order Management**: Create and retrieve orders.
- **Customer Management**: Add, view, update, and delete customer records.
- **Item Management**: Add, view, update, and delete items in the inventory.

## Technologies Used

- **Java EE**: Backend development with servlets and Java Beans.
- **Jakarta JSON Binding (JSON-B)**: JSON serialization and deserialization.
- **JNDI (Java Naming and Directory Interface)**: Database connection management.
- **MySQL**: Relational database for data storage.
- **SLF4J**: Logging.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 11 or higher
- Apache Tomcat (or any compatible servlet container)
- MySQL database and JDBC driver

### Installation

1. **Clone the Repository:**

    ```bash
    git clone https://github.com/CharakaMihiranga/JavaEE-POS.git
    cd javaee-pos-system
    ```

2. **Configure Database:**

   - **MySQL Setup**: Ensure MySQL is installed and a database is created for the POS system.
   - **JNDI Configuration**: Update the JNDI resource configuration in your servlet container (e.g., Tomcat) to include a DataSource resource for MySQL.

     Example JNDI configuration for Tomcat:
     ```xml
     <Resource name="jdbc/posSystem" auth="Container" type="javax.sql.DataSource"
               maxActive="100" maxIdle="30" maxWait="10000"
               username="your_db_username" password="your_db_password"
               driverClassName="com.mysql.cj.jdbc.Driver"
               url="jdbc:mysql://localhost:3306/your_db_name"/>
     ```

3. **Build and Deploy:**

   - If using Maven:
     ```bash
     mvn clean install
     ```
   - Deploy the generated WAR file to your servlet container (e.g., Tomcat).

4. **Start the Server:**

   Start your servlet container and deploy the application.

## API Documentation

The API provides endpoints for managing orders, customers, and items. For detailed API documentation, including request and response formats, please refer to the [API Documentation](https://documenter.getpostman.com/view/35384500/2sA3s3GWG7).

## JNDI Configuration

The project uses JNDI for managing database connections, abstracting connection details from application code for more flexible configuration.

- **JNDI Resource Lookup**: Database connection is obtained through JNDI lookup, configured in the servlet container (e.g., Tomcat).

## MySQL Database

- **Database Setup**: MySQL is used for data storage. Ensure MySQL is properly installed and a database is created for this application.
- **Schema**: Set up the database schema to include tables for customers, items, and orders.

## Logging

Logging is handled using SLF4J with default configuration. Logs are available in server logs and can be adjusted as needed.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request with your changes, adhering to the project's coding standards and including appropriate tests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

