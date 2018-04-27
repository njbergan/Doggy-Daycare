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
  `Aggressor` int(11) NOT NULL,
  `Victim` int(11) NOT NULL,
  `Incident_Date` date NOT NULL,
  `Incident_Description` longtext NOT NULL,
  PRIMARY KEY (`Incident_ID`),
  KEY `FK_aggression_aggressor_idx` (`Aggressor`),
  KEY `FK_aggression_victim_idx` (`Victim`),
  CONSTRAINT `FK_aggression_aggressor` FOREIGN KEY (`Aggressor`) REFERENCES `aggressor` (`Aggressor_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_aggression_victim` FOREIGN KEY (`Victim`) REFERENCES `victim` (`Victim_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggression`
--

LOCK TABLES `aggression` WRITE;
/*!40000 ALTER TABLE `aggression` DISABLE KEYS */;
INSERT INTO `aggression` VALUES (1,1,1,'2018-04-17','Zoe stole Mia\'s toy and nipped her side when Mia tried to stop her. No injuries on either dog.');
/*!40000 ALTER TABLE `aggression` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aggressor`
--

DROP TABLE IF EXISTS `aggressor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aggressor` (
  `Aggressor_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dog_ID` int(11) NOT NULL,
  PRIMARY KEY (`Aggressor_ID`),
  UNIQUE KEY `Dog_ID_UNIQUE` (`Dog_ID`),
  KEY `FK_aggressor_dog_idx` (`Dog_ID`),
  CONSTRAINT `FK_aggressor_dog` FOREIGN KEY (`Dog_ID`) REFERENCES `dog` (`Dog_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggressor`
--

LOCK TABLES `aggressor` WRITE;
/*!40000 ALTER TABLE `aggressor` DISABLE KEYS */;
INSERT INTO `aggressor` VALUES (1,100);
/*!40000 ALTER TABLE `aggressor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classes` (
  `Class_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Class_Name` varchar(45) NOT NULL,
  `Class_Description` varchar(45) NOT NULL,
  PRIMARY KEY (`Class_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1,'Basic Manners','Learn all the basics!'),(2,'Advanced Manners 2','Learn fun and useful commands!'),(3,'Agility Training','Improve speed and skill!'),(4,'Private Training','One-on-ones, perfect for in-depth training!');
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
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
  `Age` int(2) NOT NULL,
  `Vaccinations` tinyint(1) NOT NULL COMMENT 'Two values: 0 = Not Vaccinated; 1 = Vaccinated',
  `Last_Visit` date DEFAULT NULL,
  `Active_Flag` tinyint(1) NOT NULL COMMENT 'Two possible entries: 0 = Inactive; 1 = Active.',
  `Todays_Playground` int(11) DEFAULT NULL,
  `Todays_Classes` int(11) DEFAULT NULL,
  PRIMARY KEY (`Dog_ID`),
  KEY `Owner_ID_idx` (`Owner_ID`),
  KEY `FK_playground_dog_idx` (`Todays_Playground`),
  KEY `FK_classes_dog_idx` (`Todays_Classes`),
  CONSTRAINT `FK_classes_dog` FOREIGN KEY (`Todays_Classes`) REFERENCES `classes` (`Class_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_owner_dog` FOREIGN KEY (`Owner_ID`) REFERENCES `owner` (`Owner_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_playground_dog` FOREIGN KEY (`Todays_Playground`) REFERENCES `playground` (`Playground_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COMMENT='Stores information on each dog registered with the daycare.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog`
--

LOCK TABLES `dog` WRITE;
/*!40000 ALTER TABLE `dog` DISABLE KEYS */;
INSERT INTO `dog` VALUES (100,1000,'Zoe','Poodle','F','2017-05-15',4,1,'2018-04-13',1,NULL,NULL),(101,1001,'Winnie','Golden Retriever','F','2017-05-15',6,1,'2017-10-05',0,NULL,NULL),(102,1002,'Bubba','Bulldog','M','2017-05-15',3,1,'2018-04-02',1,NULL,NULL),(103,1003,'Lady','Mixed','F','2017-05-15',7,1,'2018-04-13',1,NULL,NULL),(104,1003,'Cash','Chihuahua','M','2017-05-15',8,1,'2017-06-21',0,NULL,NULL),(105,1004,'Rocky','Poodle','M','2017-05-22',2,1,'2017-11-08',0,NULL,NULL),(106,1005,'Jasper','Beagle','M','2017-06-14',5,1,'2018-02-01',0,NULL,NULL),(107,1006,'Mia','Great Dane','F','2017-06-28',2,1,'2018-03-30',1,NULL,NULL),(108,1006,'Ranger','Siberian Husky','M','2017-07-09',3,1,'2018-04-13',1,NULL,NULL),(109,1005,'Grace','Pug','F','2017-08-22',2,1,'2017-12-11',0,NULL,NULL),(110,1007,'Chewy','Chow Chow','M','2017-09-06',4,1,'2017-09-30',0,NULL,NULL),(111,1002,'Holly','Yorkshire Terrier','F','2017-09-23',10,1,'2018-04-13',1,NULL,NULL),(112,1007,'Princess','Border Collie','F','2017-10-04',1,1,'2018-01-10',0,NULL,NULL),(113,1004,'Athena','Australian Shepherd','F','2017-11-13',3,1,'2018-04-13',1,NULL,NULL),(114,1006,'Zoe','Newfoundland','F','2017-12-20',2,1,'2018-04-13',1,NULL,NULL),(115,1007,'Otis','Bichon Frise','M','2018-01-18',1,0,NULL,0,NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=1008 DEFAULT CHARSET=utf8 COMMENT='Stores data for dog owners. Owners may own multiple dogs, stored in the Dog table.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (1000,'Chapman','Marcella','329 Crescent Ave','Des Moines','IA','50307','5152186497',1),(1001,'Rodriguez','Peggy','20 Old Town Rd','Des Moines','IA','50316','5159712223',0),(1002,'Goodman','Dean','8183 Bay Lane','Ankeny','IA','50021','5159462318',1),(1003,'Scott','Marianne','981 King Ave.','Waukee','IA','50263','5153647108',1),(1004,'Ellis','Tamara','790B Vernon Ave','Altoona','IA','50009','5156334411',1),(1005,'Guerrero','Irene','49 East Andover Ave','West Des Moines','IA','50263','5158768622',0),(1006,'Lawrence','Jeffrey','98 Vine Road ','West Des Moines','IA','50263','5154632888',1),(1007,'Hall','John','43 Woodsman St','Des Moines','IA','50301','5154067181',0);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='Stores information on playgrounds available. Used in planning dog activities and preventing aggressive dog pairs.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `playground`
--

LOCK TABLES `playground` WRITE;
/*!40000 ALTER TABLE `playground` DISABLE KEYS */;
INSERT INTO `playground` VALUES (1,'Red Room','Inside'),(2,'Blue Room','Inside'),(3,'Yellow Room','Inside'),(4,'Green Yard','Outside'),(5,'Orange Yard','Outside'),(6,'Purple Yard','Outside');
/*!40000 ALTER TABLE `playground` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `victim`
--

DROP TABLE IF EXISTS `victim`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `victim` (
  `Victim_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Dog_ID` int(11) NOT NULL,
  PRIMARY KEY (`Victim_ID`),
  UNIQUE KEY `Dog_ID_UNIQUE` (`Dog_ID`),
  KEY `FK_victim_dog_idx` (`Dog_ID`),
  CONSTRAINT `FK_victim_dog` FOREIGN KEY (`Dog_ID`) REFERENCES `dog` (`Dog_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `victim`
--

LOCK TABLES `victim` WRITE;
/*!40000 ALTER TABLE `victim` DISABLE KEYS */;
INSERT INTO `victim` VALUES (1,107);
/*!40000 ALTER TABLE `victim` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-24 14:01:38
