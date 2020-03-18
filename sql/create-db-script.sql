DROP DATABASE IF EXISTS `sql_starwars`;
CREATE DATABASE `sql_starwars`;
USE `sql_starwars`;

CREATE TABLE `user` (
  `userid` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `user` VALUES ('guest', 'guess user');


CREATE TABLE `favorite` (
  `id` bigInt(8) NOT NULL AUTO_INCREMENT,
  `userid` varchar(50) NOT NULL,
  `favorite_imdbID` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_userid_idx` (`userid`),
  CONSTRAINT `fk_userid` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
INSERT INTO `favorite` VALUES ('1', 'guest', 'tt2488496');

CREATE TABLE `request_history` (
  `id` bigint(8) NOT NULL AUTO_INCREMENT,
  `request_query` varchar(300) NOT NULL,
  `requestor_ip_address` varchar(50),
  `timestamp` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;