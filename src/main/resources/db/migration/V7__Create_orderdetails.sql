CREATE TABLE `orderdetails` (
  `order_number` int(11) NOT NULL,
  `product_code` varchar(15) NOT NULL,
  `quantity_ordered` int(11) NOT NULL,
  `price_each` decimal(10,2) NOT NULL,
  `order_line_number` smallint(6) NOT NULL,
  PRIMARY KEY (`order_number`,`product_code`),
  KEY `product_code` (`product_code`),
  CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`),
  CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`product_code`) REFERENCES `products` (`product_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;