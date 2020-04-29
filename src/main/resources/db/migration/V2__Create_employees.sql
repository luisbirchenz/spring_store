CREATE TABLE `employees` (
  `employee_number` int(11) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `extension` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `office_code` varchar(10) NOT NULL,
  `reports_to` int(11) DEFAULT NULL,
  `job_title` varchar(50) NOT NULL,
  PRIMARY KEY (`employee_number`),
  KEY `reportsTo` (`reports_to`),
  KEY `office_code` (`office_code`),
  CONSTRAINT `employees_ibfk_1` FOREIGN KEY (`reports_to`) REFERENCES `employees` (`employee_number`),
  CONSTRAINT `employees_ibfk_2` FOREIGN KEY (`office_code`) REFERENCES `offices` (`office_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;