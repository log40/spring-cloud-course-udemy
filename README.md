# Microservices using Spring Cloud

This repository contains a follow-up to the Udemy course "Spring Boot Microservices, Spring Cloud Netflix Eureka 2025". It includes the implementation of different services that interact with each other.

**Link to the course by Andrés Guzmán:**
https://www.udemy.com/course/microservicios-con-spring-boot-y-spring-cloud/

---

#### Content

<!-- TOC -->
* [Microservices using Spring Cloud](#microservices-using-spring-cloud)
    * [Technologies](#technologies)
    * [Services](#services)
<!-- TOC -->

---

#### Technologies


![Java](https://img.shields.io/badge/Java-21-orange?style=flat&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.0-brightgreen?style=flat&logo=springboot&logoColor=white)
![Spring Cloud](https://img.shields.io/badge/Spring_Cloud-2023.0.2-brightgreen?style=flat&logo=spring&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-gray?style=flat&logo=spring&logoColor=white)
![Jakarta EE](https://img.shields.io/badge/Jakarta_EE-blue?style=flat&logo=eclipse-jakarta-ee&logoColor=white)
![Lombok](https://img.shields.io/badge/Lombok-red?style=flat)
![Docker](https://img.shields.io/badge/Docker-blue?style=flat&logo=docker&logoColor=white)

---

#### Services

- **product-ms:** Service responsible for managing product information. It runs on port 8001.
- **item-ms:** Service that consumes the product-ms API using OpenFeign to manage items. It runs on port 8002.
