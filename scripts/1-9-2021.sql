-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: blooddonationdb
-- ------------------------------------------------------
-- Server version	8.0.25

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blood_bank`
--

DROP TABLE IF EXISTS `blood_bank`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_bank` (
  `BLOODBANKID` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `CONTACTNO` int NOT NULL,
  PRIMARY KEY (`BLOODBANKID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_bank`
--

LOCK TABLES `blood_bank` WRITE;
/*!40000 ALTER TABLE `blood_bank` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_bank` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_group_id`
--

DROP TABLE IF EXISTS `blood_group_id`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_group_id` (
  `BLOODGROUPID` int NOT NULL,
  `BLOODGROUP` varchar(45) NOT NULL,
  PRIMARY KEY (`BLOODGROUPID`),
  UNIQUE KEY `BLOODGROUPID_UNIQUE` (`BLOODGROUPID`),
  UNIQUE KEY `BLOODGROUP_UNIQUE` (`BLOODGROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_group_id`
--

LOCK TABLES `blood_group_id` WRITE;
/*!40000 ALTER TABLE `blood_group_id` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_group_id` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_request`
--

DROP TABLE IF EXISTS `blood_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_request` (
  `REQUESTID` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `REQUESTDATE` varchar(45) NOT NULL,
  `BLOOD_GROUP` varchar(45) NOT NULL,
  `QUANTITY` varchar(45) NOT NULL,
  `CONTACTNO` int NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  PRIMARY KEY (`REQUESTID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_request`
--

LOCK TABLES `blood_request` WRITE;
/*!40000 ALTER TABLE `blood_request` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blood_stock`
--

DROP TABLE IF EXISTS `blood_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blood_stock` (
  `STOCK_ID` int NOT NULL AUTO_INCREMENT,
  `BLOOD_GROUP` varchar(45) NOT NULL,
  `QUANTITY` double NOT NULL,
  `DONATION_DATE` date NOT NULL,
  `EXP_DATE` date NOT NULL,
  PRIMARY KEY (`STOCK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_stock`
--

LOCK TABLES `blood_stock` WRITE;
/*!40000 ALTER TABLE `blood_stock` DISABLE KEYS */;
/*!40000 ALTER TABLE `blood_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donor`
--

DROP TABLE IF EXISTS `donor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donor` (
  `DONORID` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `GENDER` varchar(45) NOT NULL,
  `DOB` date NOT NULL,
  `WEIGHT` int NOT NULL,
  `BLOODGROUP` varchar(45) NOT NULL,
  `CONTACTNO` int NOT NULL,
  `EMAILID` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  PRIMARY KEY (`DONORID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`),
  UNIQUE KEY `EMAILID_UNIQUE` (`EMAILID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
/*!40000 ALTER TABLE `donor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hospital`
--

DROP TABLE IF EXISTS `hospital`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hospital` (
  `HOSPITALID` int NOT NULL AUTO_INCREMENT,
  `UID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  `EMAILID` varchar(45) NOT NULL,
  `CONTACTNO` varchar(45) NOT NULL,
  PRIMARY KEY (`HOSPITALID`),
  UNIQUE KEY `EMAILID_UNIQUE` (`EMAILID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `UID` int NOT NULL AUTO_INCREMENT,
  `ROLL_ID` int NOT NULL,
  `NAME` varchar(45) NOT NULL,
  `LOGINID` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `SQUESTION` int NOT NULL,
  `ANSWER` varchar(45) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `LOGINID_UNIQUE` (`LOGINID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-31 22:49:51
