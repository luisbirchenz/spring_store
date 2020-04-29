CREATE TABLE `customers` (
  `customer_number` int(11) NOT NULL,
  `customer_name` varchar(50) NOT NULL,
  `contact_last_name` varchar(50) NOT NULL,
  `contact_first_name` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address_line1` varchar(50) NOT NULL,
  `address_line2` varchar(50) DEFAULT NULL,
  `city` varchar(50) NOT NULL,
  `state` varchar(50) DEFAULT NULL,
  `postal_code` varchar(15) DEFAULT NULL,
  `country` varchar(50) NOT NULL,
  `sales_rep_employee_number` int(11) DEFAULT NULL,
  `credit_limit` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`customer_number`),
  KEY `sales_rep_employee_number` (`sales_rep_employee_number`),
  CONSTRAINT `customers_ibfk_1` FOREIGN KEY (`sales_rep_employee_number`) REFERENCES `employees` (`employee_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;