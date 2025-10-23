# Home Loan Management System

A Spring Boot application for managing home loan applications, customer data, and EMI calculations.

## Features

- Customer management
- Loan application processing
- EMI schedule generation and tracking
- RESTful API endpoints
- MySQL database integration

## Technology Stack

- **Java 23**
- **Spring Boot 3.5.6**
- **Spring Data JPA**
- **Hibernate**
- **MySQL 8.0**
- **Maven**

## Getting Started

### Prerequisites

- Java 23 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

### Database Setup

1. Create a MySQL database named `home_loan_nbfcs`
2. The application will automatically create the required tables on startup

### Environment Configuration

1. Copy the environment template:
   ```bash
   cp .env.template .env
   ```

2. Edit `.env` file with your database credentials:
   ```properties
   DB_URL=jdbc:mysql://localhost:3306/home_loan_nbfcs
   DB_USERNAME=your-username
   DB_PASSWORD=your-password
   ```

3. Source the environment variables (or use your IDE's environment configuration):
   ```bash
   source .env
   export DB_URL DB_USERNAME DB_PASSWORD
   ```

### Running the Application

1. Build the project:
   ```bash
   ./mvnw clean install
   ```

2. Run the application:
   ```bash
   ./mvnw spring-boot:run
   ```

The application will start on `http://localhost:8080`

### API Endpoints

#### Loan Management

- **Apply for Loan**
  ```
  POST /loans/apply
  Content-Type: application/json
  
  {
    "customer": {
      "name": "John Doe",
      "email": "john@example.com",
      "phone": "1234567890",
      "address": "123 Main St"
    },
    "amount": 500000,
    "tenureMonths": 240
  }
  ```

- **Approve Loan**
  ```
  POST /loans/{loanId}/approve
  ```

- **Reject Loan**
  ```
  POST /loans/{loanId}/reject
  ```

- **Get EMI Schedule**
  ```
  GET /loans/{loanId}/emis
  ```

### Database Schema

The application creates the following tables:

- `customer` - Customer information
- `loan_application` - Loan application details
- `emi` - EMI schedule and payment tracking

### Testing

Run the test suite:
```bash
./mvnw test
```

## Security Notes

- Database credentials are externalized to environment variables
- The `.env` file is excluded from version control
- Never commit sensitive information to the repository

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests for new functionality
5. Ensure all tests pass
6. Submit a pull request

## License

This project is licensed under the MIT License.