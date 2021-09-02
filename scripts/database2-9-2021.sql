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
  `CONTACTNO` varchar(10) NOT NULL,
  `EmailID` varchar(45) NOT NULL,
  PRIMARY KEY (`BLOODBANKID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`),
  KEY `USER_ID_idx` (`UID`),
  CONSTRAINT `USER_ID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_bank`
--

LOCK TABLES `blood_bank` WRITE;
/*!40000 ALTER TABLE `blood_bank` DISABLE KEYS */;
INSERT INTO `blood_bank` VALUES (1,1,'Kedar Beedkar','Shivaji Nagar','Pune','9404864721','Lifestreambloodbank@gamil.com');
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
  `BLOODGROUP` varchar(10) NOT NULL,
  PRIMARY KEY (`BLOODGROUPID`),
  UNIQUE KEY `BLOODGROUP_UNIQUE` (`BLOODGROUP`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_group_id`
--

LOCK TABLES `blood_group_id` WRITE;
/*!40000 ALTER TABLE `blood_group_id` DISABLE KEYS */;
INSERT INTO `blood_group_id` VALUES (2,'A-'),(1,'A+'),(4,'AB-'),(3,'AB+'),(6,'B-'),(5,'B+'),(8,'O-'),(7,'O+');
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
  `PNAME` varchar(45) NOT NULL,
  `REQUEST_DATE` date NOT NULL,
  `BLOODGROUP_ID` int NOT NULL,
  `QUANTITY` double NOT NULL,
  `PCONTACTNO` varchar(13) NOT NULL,
  `PADDRESS` varchar(45) NOT NULL,
  `REQUESTSTATUS` varchar(45) NOT NULL,
  PRIMARY KEY (`REQUESTID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`PCONTACTNO`),
  KEY `UID_idx` (`UID`),
  KEY `BLOOD_GROUP ID_idx` (`BLOODGROUP_ID`),
  CONSTRAINT `BLOODGROUP_ID` FOREIGN KEY (`BLOODGROUP_ID`) REFERENCES `blood_group_id` (`BLOODGROUPID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `USERID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
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
  `STOCKID` int NOT NULL AUTO_INCREMENT,
  `BLOODGROUP_ID` int NOT NULL,
  `QUANTITY` double NOT NULL,
  `DONATION_DATE` date NOT NULL,
  PRIMARY KEY (`STOCKID`),
  KEY `BLOOD_GROUP ID_idx` (`BLOODGROUP_ID`),
  CONSTRAINT `BLOOD_GROUP ID` FOREIGN KEY (`BLOODGROUP_ID`) REFERENCES `blood_group_id` (`BLOODGROUPID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blood_stock`
--

LOCK TABLES `blood_stock` WRITE;
/*!40000 ALTER TABLE `blood_stock` DISABLE KEYS */;
INSERT INTO `blood_stock` VALUES (1,1,13,'2021-09-02'),(2,2,15,'2021-09-02'),(3,3,34,'2021-09-02'),(4,4,21,'2021-09-02'),(5,5,15,'2021-09-02'),(6,6,45,'2021-09-02'),(7,7,36,'2021-09-02'),(8,8,41,'2021-09-02');
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
  `BLOODGROUP_ID` int NOT NULL,
  `CONTACTNO` varchar(13) NOT NULL,
  `EMAILID` varchar(45) NOT NULL,
  `ADDRESS` varchar(45) NOT NULL,
  `CITY` varchar(45) NOT NULL,
  PRIMARY KEY (`DONORID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`),
  UNIQUE KEY `EMAILID_UNIQUE` (`EMAILID`),
  KEY `BLOODGROUP ID_idx` (`BLOODGROUP_ID`),
  KEY `UID_idx` (`UID`),
  CONSTRAINT `BLOODGROUP ID` FOREIGN KEY (`BLOODGROUP_ID`) REFERENCES `blood_group_id` (`BLOODGROUPID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `UID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donor`
--

LOCK TABLES `donor` WRITE;
/*!40000 ALTER TABLE `donor` DISABLE KEYS */;
INSERT INTO `donor` VALUES (1,2,'Jyotika Sable','F','1999-03-30',1,'7972925368','jyotikasable199@gmail.com','Pimpari-chinchwad','Pune'),(2,3,'Shaikh Naheed','F','1997-11-22',3,'8329350938','shaikhnaheed1123@gmail.com','Nirvaan Nagar','Jalana'),(3,4,'Jayashri Kathore','F','1995-05-15',5,'8390638530','Jayshrikathore6@gmail.com','Hinjewadi ','Pune');
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
  `CONTACTNO` varchar(13) NOT NULL,
  PRIMARY KEY (`HOSPITALID`),
  UNIQUE KEY `EMAILID_UNIQUE` (`EMAILID`),
  UNIQUE KEY `CONTACTNO_UNIQUE` (`CONTACTNO`),
  KEY `USER ID_idx` (`UID`),
  CONSTRAINT `USER ID` FOREIGN KEY (`UID`) REFERENCES `user` (`UID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hospital`
--

LOCK TABLES `hospital` WRITE;
/*!40000 ALTER TABLE `hospital` DISABLE KEYS */;
INSERT INTO `hospital` VALUES (1,5,'Sancheti Hospital','Shivaji Nagar','Pune','hospitalsancheti@gmail.com','9999956123');
/*!40000 ALTER TABLE `hospital` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_status`
--

DROP TABLE IF EXISTS `request_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_status` (
  `REQUESTID` int NOT NULL,
  `UID` int NOT NULL,
  PRIMARY KEY (`REQUESTID`,`UID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_status`
--

LOCK TABLES `request_status` WRITE;
/*!40000 ALTER TABLE `request_status` DISABLE KEYS */;
/*!40000 ALTER TABLE `request_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_question`
--

DROP TABLE IF EXISTS `security_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `security_question` (
  `SQUESTIONID` int NOT NULL AUTO_INCREMENT,
  `SECURITY_QUESTION` varchar(45) NOT NULL,
  PRIMARY KEY (`SQUESTIONID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_question`
--

LOCK TABLES `security_question` WRITE;
/*!40000 ALTER TABLE `security_question` DISABLE KEYS */;
INSERT INTO `security_question` VALUES (1,'What is your country name?'),(2,'what was your favorite subject ?'),(3,'what is your favorite book?');
/*!40000 ALTER TABLE `security_question` ENABLE KEYS */;
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
  `LOGINID` varchar(45) NOT NULL,
  `PASSWORD` varchar(45) NOT NULL,
  `SQUESTIONID` int NOT NULL,
  `ANSWER` varchar(45) NOT NULL,
  PRIMARY KEY (`UID`),
  UNIQUE KEY `LOGINID_UNIQUE` (`LOGINID`),
  KEY `SQUESTIONID_idx` (`SQUESTIONID`),
  CONSTRAINT `SQUESTION_ID` FOREIGN KEY (`SQUESTIONID`) REFERENCES `security_question` (`SQUESTIONID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,1,'beedkarkedar@gmail.com','kedar@admin123',1,'india'),(2,2,'jyotikasable199@gmail.com','jyotika@123',1,'india'),(3,2,'shaikhnaheed1123@gmail.com','naheed@123',1,'india'),(4,2,'Jayshrikathore6@gmail.com','jayshree@123',1,'india'),(5,3,'hospitalsancheti@gmail.com','sancheti@hospital123',1,'india');
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

-- Dump completed on 2021-09-02 23:30:51
