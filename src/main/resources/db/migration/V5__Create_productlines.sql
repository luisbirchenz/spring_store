CREATE TABLE `productlines` (
  `product_line_id` int(10) NOT NULL AUTO_INCREMENT,
  `product_line` varchar(50) NOT NULL,
  `text_description` varchar(4000) DEFAULT NULL,
  `html_description` mediumtext,
  `image` varchar(50),
  PRIMARY KEY (`product_line_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;