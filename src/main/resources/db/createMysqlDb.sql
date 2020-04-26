-- run this as root or dba user in order to create the database for this application.
CREATE DATABASE `mystore` /*!40100 COLLATE 'utf8_general_ci' */;
CREATE USER 'storeusr'@'%' IDENTIFIED BY 'store123';
GRANT USAGE ON *.* TO 'storeusr'@'%';
GRANT SELECT, EXECUTE, SHOW VIEW, ALTER, ALTER ROUTINE, CREATE, CREATE ROUTINE, CREATE TEMPORARY TABLES, CREATE VIEW, DELETE, DROP, EVENT, INDEX, INSERT, REFERENCES, TRIGGER, UPDATE, LOCK TABLES  ON `mystore`.* TO 'storeusr'@'%' WITH GRANT OPTION;
FLUSH PRIVILEGES;
