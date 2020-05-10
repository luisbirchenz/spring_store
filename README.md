# My Store demo
This is a Monolithic application which was created in order to understand the business involved much better and at the same time I will try to follow the best practices recommended for it

This project is going to use: 
* Spring boot
* Spring Rest Controllers
* Spring data Jpa
* Spring actuator
* Lombok
* JUnit 5
* Mockito
* DBUnit
* Mysql 
* H2 - For testing
* Swagger
* Flyway

I've been working on this project by analyzing the model on which it is based. Consider that the data shown here was found and download from this link (where the database example is available for everyone) [here](https://www.mysqltutorial.org/mysql-sample-database.aspx)

The MySQL sample database schema consists of the following tables:

* Customers: stores customer’s data.
* Products: stores a list of scale model cars.
* ProductLines: stores a list of product line categories.
* Orders: stores sales orders placed by customers.
* OrderDetails: stores sales order line items for each sales order.
* Payments: stores payments made by customers based on their accounts.
* Employees: stores all employee information as well as the organization structure such as who reports to whom.
* Offices: stores sales office data.

This model can be updated in the course of development if new ideas about this come up.

The idea is to understand the proposed business well and then move it to microservices. So, after testing a couple of things here this project will be converted to microservices. 

The project where it is going to happen is availabe under this [link](https://github.com/luisbirchenz/storeapp). The status is: working in progress.



