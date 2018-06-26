# create databases
CREATE DATABASE IF NOT EXISTS `zup`;
CREATE DATABASE IF NOT EXISTS `zup_test`;

# create root user and grant rights
CREATE USER 'root'@'localhost' IDENTIFIED BY 'local';
GRANT ALL ON *.* TO 'root'@'%';

USE zup_test;

CREATE TABLE IF NOT EXISTS `poi` (
  `cod` bigint(20) NOT NULL AUTO_INCREMENT,
  `coordinatex` bigint(20) NOT NULL,
  `coordinatey` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cod`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

