# rdspbootsec
spring boot application with native form login

# Goal
- Web application with rich ui using Thymeleaf
- Native form-based login
- Persistence using JPA, MySQL

# Prerequisite configuration
## Database setup
- Install MySQL / MariaDB database
- As "root" user, run Database Schema SQL file to create database, user
  - Refer: scripts/database.sql 

## Setup Application Instance/VM
- If using AWS Account, use the CloudFormation Template file: **scripts/app_vm.yaml**
- If installation on any other environment, follow below steps:
  - Install JDK 1.8.x
  - Install Maven 3.5.2

## Application Configuration
- Update JDBC URL with Database Host / IP

## Build Application
- Change directory to **demo**
- Build Project
```
mvn -DskipTests clean install
```

## Run Spring Boot Application
- Change directory to **demo**
- Launch application
```
mvn spring-boot:run
```

## Verify Application
- Access Application URL on Web Browser
- http://<host>:8080/

## Application Data
- To use the application, you need to upload data
- Register your username/password first
- Login with your username
- Click on **Upload Models** menu item
- Upload the sample data file: **data/car_prices_10000.csv**
- Click on **Upload Sellers** menu item
- Upload the sample data file: **data/car_prices_10000.csv**

