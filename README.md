# My Store demo
This is a Monolithic application to test Flyway database migrations, in order to demo JUnit test and integration test techniques 
with Spring boot and to show some features of Spring Actuator. The data shown here was found and download from this link (where
the database example is available for everyone) [here](https://www.mysqltutorial.org/mysql-sample-database.aspx)

The MySQL sample database schema consists of the following tables:

* Customers: stores customer’s data.
* Products: stores a list of scale model cars.
* ProductLines: stores a list of product line categories.
* Orders: stores sales orders placed by customers.
* OrderDetails: stores sales order line items for each sales order.
* Payments: stores payments made by customers based on their accounts.
* Employees: stores all employee information as well as the organization structure such as who reports to whom.
* Offices: stores sales office data.

After testing a couple of things here this project will be converted to microservices. The idea is to migrate to microservices
by following the best known patterns.

Just to mention, the idea is to use:

* Spring cloud (Netflix - Eureka, Zool, Ribbon, etc..)
* Axon Framework (CQRS / Event Sourcing / Saga pattern)

Once this process is completed the link to the next project will be included here soon.


