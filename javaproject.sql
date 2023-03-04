-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: javaproject
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `login_user`
--

DROP TABLE IF EXISTS `login_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login_user` (
  `username` varchar(10) NOT NULL,
  `formno` int NOT NULL,
  `password` varchar(6) NOT NULL,
  `enrollno` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`formno`),
  CONSTRAINT `login_user_chk_1` CHECK ((`enrollno` like _utf8mb4'A%'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login_user`
--

LOCK TABLES `login_user` WRITE;
/*!40000 ALTER TABLE `login_user` DISABLE KEYS */;
INSERT INTO `login_user` VALUES ('Nikhil',11212,'wezxcx','A6721'),('Bishwa',12312,'qazwsx','A1234'),('Akash',15612,'wezwsx','A1567');
/*!40000 ALTER TABLE `login_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `semester_de`
--

DROP TABLE IF EXISTS `semester_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `semester_de` (
  `subject_1` varchar(10) NOT NULL,
  `subject_2` varchar(10) NOT NULL,
  `subject_3` varchar(10) NOT NULL,
  `foreign_lang` varchar(10) NOT NULL,
  `formno` int DEFAULT NULL,
  KEY `formno` (`formno`),
  CONSTRAINT `semester_de_ibfk_1` FOREIGN KEY (`formno`) REFERENCES `student_details` (`formno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `semester_de`
--

LOCK TABLES `semester_de` WRITE;
/*!40000 ALTER TABLE `semester_de` DISABLE KEYS */;
INSERT INTO `semester_de` VALUES ('maths','physics','chemistry','spanish',11212),('maths','physics','chemistry','french',12312);
/*!40000 ALTER TABLE `semester_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_details`
--

DROP TABLE IF EXISTS `student_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_details` (
  `formno` int NOT NULL,
  `name` varchar(10) NOT NULL,
  `enroll` varchar(5) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `course` varchar(6) NOT NULL,
  `phoneno` int NOT NULL,
  `semester` varchar(1) NOT NULL,
  PRIMARY KEY (`formno`),
  CONSTRAINT `student_details_chk_1` CHECK ((`enroll` like _utf8mb4'A%')),
  CONSTRAINT `student_details_chk_2` CHECK ((`email` like _utf8mb4'%@%.%'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_details`
--

LOCK TABLES `student_details` WRITE;
/*!40000 ALTER TABLE `student_details` DISABLE KEYS */;
INSERT INTO `student_details` VALUES (11212,'Nikhil','A6721','nik@gmail.com','B.tech',978123456,'4'),(12312,'Bishwa','A6721','bis@gmail.com','B.tech',923423456,'5');
/*!40000 ALTER TABLE `student_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-13 16:17:07
