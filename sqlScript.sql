CREATE DATABASE  IF NOT EXISTS `users_sign_up_details`;
USE `users_sign_up_details`;

--
-- Table structure for table `users`
--

CREATE TABLE `usersdetails` (
  `firstName` varchar(15) NOT NULL,
  `lastName` varchar(15) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(15) NOT NULL,
  `city` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(15) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(20) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci




CREATE TABLE `root` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(50) NOT NULL,
  `rootName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_AND_ROOTNAME_UNIQUE` (`userName`,`rootName`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=latin1

CREATE TABLE `subroot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subrootName` varchar(50) DEFAULT NULL,
  `root_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_AND_ROOTNAME_SUBROOTNAME_UNIQUE` (`subrootName`,`root_id`),
  KEY `FK_ROOT_ID_idx` (`root_id`),
  CONSTRAINT `FK_ROOT` FOREIGN KEY (`root_id`) REFERENCES `root` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1

