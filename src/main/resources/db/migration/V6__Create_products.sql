CREATE TABLE `products` (
  `product_code` varchar(15) NOT NULL,
  `product_name` varchar(70) NOT NULL,
  `product_line_id` int(10) NOT NULL,
  `product_scale` varchar(10) NOT NULL,
  `product_vendor` varchar(50) NOT NULL,
  `product_description` text NOT NULL,
  `quantity_in_stock` smallint(6) NOT NULL,
  `buy_price` decimal(10,2) NOT NULL,
  `MSRP` decimal(10,2) NOT NULL,
  PRIMARY KEY (`product_code`),
  KEY `productline` (`product_line_id`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`product_line_id`) REFERENCES `productlines` (`product_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;