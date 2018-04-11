-- MySQL dump 10.13  Distrib 5.7.20, for Win64 (x86_64)
--
-- Host: localhost    Database: doggy_daycare
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `aggression`
--

DROP TABLE IF EXISTS `aggression`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aggression` (
  `Incident_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dog_1` int(11) NOT NULL,
  `Dog_2` int(11) NOT NULL,
  `Incident_Date` date NOT NULL,
  `Incident_Description` longtext NOT NULL,
  PRIMARY KEY (`Incident_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores aggression incidents, logging the event and assisting future playground scheduling.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggression`
--

LOCK TABLES `aggression` WRITE;
/*!40000 ALTER TABLE `aggression` DISABLE KEYS */;
/*!40000 ALTER TABLE `aggression` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dog`
--

DROP TABLE IF EXISTS `dog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dog` (
  `Dog_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Owner_ID` int(11) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Breed` varchar(25) NOT NULL,
  `Gender` varchar(1) NOT NULL,
  `Registration_Date` date NOT NULL,
  `Vaccinations` tinyint(1) NOT NULL COMMENT 'Two values: 0 = Not Vaccinated; 1 = Vaccinated',
  `Last_Visit` date DEFAULT NULL,
  `Active_Flag` tinyint(1) NOT NULL COMMENT 'Two possible entries: 0 = Inactive; 1 = Active.',
  PRIMARY KEY (`Dog_ID`),
  KEY `Owner_ID_idx` (`Owner_ID`),
  CONSTRAINT `FK_owner_dog` FOREIGN KEY (`Owner_ID`) REFERENCES `owner` (`Owner_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores information on each dog registered with the daycare.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog`
--

LOCK TABLES `dog` WRITE;
/*!40000 ALTER TABLE `dog` DISABLE KEYS */;
/*!40000 ALTER TABLE `dog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `Owner_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Last_Name` varchar(25) NOT NULL,
  `First_Name` varchar(25) NOT NULL,
  `Street` varchar(45) NOT NULL,
  `City` varchar(25) NOT NULL,
  `State` varchar(2) NOT NULL,
  `Zip` varchar(10) NOT NULL,
  `Phone` varchar(15) NOT NULL,
  `Active_Flag` tinyint(1) NOT NULL COMMENT 'Two possible entries: 0 = Not Active; 1 = Active.',
  PRIMARY KEY (`Owner_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores data for dog owners. Owners may own multiple dogs, stored in the Dog table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `playground`
--

DROP TABLE IF EXISTS `playground`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `playground` (
  `Playground_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(25) NOT NULL,
  `Location` varchar(7) NOT NULL COMMENT 'Two possible locations: Inside, Outside',
  PRIMARY KEY (`Playground_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Stores information on playgrounds available. Used in planning dog activities and preventing aggressive dog pairs.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playground`
--

LOCK TABLES `playground` WRITE;
/*!40000 ALTER TABLE `playground` DISABLE KEYS */;
/*!40000 ALTER TABLE `playground` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-10 12:51:08
