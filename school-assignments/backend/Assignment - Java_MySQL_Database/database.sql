-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mybase
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `pages` int DEFAULT NULL,
  `classification` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (1,'Den ensamma katten','Rudolf Ruskprick',123,'Hce'),(2,'Vägen till Västerås','Kenny Surströmming',244,'Hce'),(3,'Grisarnas Julafton','Orvar Satorsson',198,'Hce'),(4,'Blomkålsmördaren','Sara Tryffelsten',55,'uHce'),(5,'Min faster Ingerborg','Inga Skoghorn',763,'Hcf'),(6,'Askorbinsyra utan smör','Tore Tofs',199,'Hcf'),(7,'Lastbilens tankar','Oskar Rudenberg',452,'uHce'),(8,'Benny Bläcks liv','Benny Bläck',111,'Hce');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `borrowed_books`
--

DROP TABLE IF EXISTS `borrowed_books`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `borrowed_books` (
  `outloan_ID` int NOT NULL AUTO_INCREMENT,
  `loaner_ID` int DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `bookID` int NOT NULL,
  PRIMARY KEY (`outloan_ID`),
  KEY `loanerIndex` (`loaner_ID`),
  KEY `borrowed_books_ibfk_1` (`bookID`),
  CONSTRAINT `borrowed_books_ibfk_1` FOREIGN KEY (`bookID`) REFERENCES `books` (`Id`) ON DELETE CASCADE,
  CONSTRAINT `borrowed_books_ibfk_2` FOREIGN KEY (`loaner_ID`) REFERENCES `persons` (`loaner_ID`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `borrowed_books`
--

LOCK TABLES `borrowed_books` WRITE;
/*!40000 ALTER TABLE `borrowed_books` DISABLE KEYS */;
INSERT INTO `borrowed_books` VALUES (1,1234,'Den ensamma katten',1),(2,1234,'Blomkålsmördaren',4),(3,4536,'Lastblilens tankar',7),(4,1212,'Benny Bläcks liv',8),(5,1212,'Grisarnas Julafton',3);
/*!40000 ALTER TABLE `borrowed_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone1` int DEFAULT NULL,
  `telephone2` int DEFAULT NULL,
  `telephone3` int DEFAULT NULL,
  `monthly_salary` int DEFAULT NULL,
  `semesterdays` int DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'Asta Kask','Vägen 2, Nollberga',13647,NULL,67869,12000,10),(3,'Ebba Grön','Vägen 4, Nollberga',365868,6789,NULL,83000,21),(4,'Farbror Blå','Vägen 8, Nollberga',68686,NULL,NULL,7000,0);
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `journals`
--

DROP TABLE IF EXISTS `journals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `journals` (
  `title` varchar(255) NOT NULL,
  `release_date` date NOT NULL,
  `shelf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`title`,`release_date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `journals`
--

LOCK TABLES `journals` WRITE;
/*!40000 ALTER TABLE `journals` DISABLE KEYS */;
INSERT INTO `journals` VALUES ('Burksamlaren','2003-05-12','C'),('Burksamlaren','2003-07-12','C'),('Burksamlaren','2003-09-12','C'),('Dagens Tidning','2004-05-12','B'),('Dagens Tidning','2010-05-08','B'),('Dagens Tidning','2011-09-10','B'),('Dagens Tidning','2011-10-10','B'),('Dagens Tidning','2011-11-10','B'),('Gårdagens Tidning','2002-03-05','C'),('Gårdagens Tidning','2004-05-15','C'),('Gårdagens Tidning','2010-10-04','C'),('Gårdagens Tidning','2010-10-15','C'),('Gårdagens Tidning','2011-12-24','C'),('Gårdagens Tidning','2012-01-22','C'),('Illustrerad Ångest','2010-11-16','A'),('Illustrerad Ångest','2010-12-05','A'),('Illustrerad Ångest','2012-12-20','A'),('Moderna Trasor','2001-05-01','A'),('Moderna Trasor','2002-02-18','A'),('Moderna Trasor','2008-10-05','A'),('Moderna Trasor','2008-12-05','A'),('Moderna Trasor','2010-07-15','A'),('Nyheter från Vattenpölen','2001-04-01','B'),('Nyheter från Vattenpölen','2004-12-03','B'),('Nyheter från Vattenpölen','2006-06-24','B'),('Nyheter från Vattenpölen','2011-04-03','B'),('Veckans Tråkigaste','2001-01-19','A'),('Veckans Tråkigaste','2011-05-12','A');
/*!40000 ALTER TABLE `journals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persons`
--

DROP TABLE IF EXISTS `persons`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persons` (
  `name` varchar(255) DEFAULT NULL,
  `adress` varchar(255) DEFAULT NULL,
  `telephone` int DEFAULT NULL,
  `loaner_ID` int NOT NULL,
  PRIMARY KEY (`loaner_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persons`
--

LOCK TABLES `persons` WRITE;
/*!40000 ALTER TABLE `persons` DISABLE KEYS */;
INSERT INTO `persons` VALUES ('User','Blablavägen',30303030,321),('Explorer','Vägen 123, Nollberga',44444,1212),('Viggo','Vägen 1, Nollberga',11111,1234),('Elof','Vägen 24, Nollberga',5555,2112),('Bosse','Vägen 5, Nollberga',3333,3347),('Fyllebera','Fullgatan 2, Fullberga',2213123,4536);
/*!40000 ALTER TABLE `persons` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-14 23:34:10
