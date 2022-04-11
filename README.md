# About The Project
Amount-counting is the RESTful webservice which works with worklog. Third party service gives us worklog of all employees for time - period. URL-example: http://some-service/period/2022-03

Ammount-counting service provides functionality for allocating total amount between team members according time worked.

# Built With
1. Java 11 (https://www.oracle.com/java/technologies/downloads/#java11)
2. Maven v.4.0.0

# Getting Started
1. Clone this repository with SSH
![image](https://user-images.githubusercontent.com/73289793/162756775-63273fd1-a02d-40e6-9a8a-6634fba9677f.png)

3. Open the folder you want to store application
4. Open terminal and write 
   ```
   git clone git@github.com:wihrr/amount-counting.git
   ```
5. Open your IDE and open pom.xmp file as a project  
6. Run the application

# Technology steck
SpringBoot, Spring Web, Spring Cloud OpenFeign, Swagger, Lomboc

# Usage
As I said ammount-counting service provides functionality for allocating total amount between team members according time worked.
To see endpoints you can go to the Swagger-documentation when you run ammount-counting. For this go to the 
```
http://localhost:8080/swagger-ui.html
```
