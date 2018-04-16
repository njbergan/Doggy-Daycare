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
  PRIMARY KEY (`Incident_ID`),
  KEY `FK_dog1_aggression_idx` (`Dog_1`),
  KEY `FK_dog2_aggression_idx` (`Dog_2`),
  CONSTRAINT `FK_dog1_aggression` FOREIGN KEY (`Dog_1`) REFERENCES `dog` (`Dog_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_dog2_aggression` FOREIGN KEY (`Dog_2`) REFERENCES `dog` (`Dog_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='Stores aggression incidents, logging the event and assisting future playground scheduling.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aggression`
--

LOCK TABLES `aggression` WRITE;
/*!40000 ALTER TABLE `aggression` DISABLE KEYS */;
INSERT INTO `aggression` VALUES (1,111,100,'2017-10-15','Red Room. Zoe had tried to take Holly\'s squeak toy. Holly warned with a growl. Zoe still tried to take it, so Holly nipped at her. No broken skin on either dog.');
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
  CONSTRAINT `FK_owner_dog` FOREIGN KEY (`Owner_ID`) REFERENCES `owner` (`Owner_ID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8 COMMENT='Stores information on each dog registered with the daycare.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dog`
--

LOCK TABLES `dog` WRITE;
/*!40000 ALTER TABLE `dog` DISABLE KEYS */;
INSERT INTO `dog` VALUES (100,1000,'Zoe','Poodle','F','2017-05-15',1,'2018-04-13',1),(101,1001,'Winnie','Golden Retriever','F','2017-05-15',1,'2017-10-05',0),(102,1002,'Bubba','Bulldog','M','2017-05-15',1,'2018-04-02',1),(103,1003,'Lady','Mixed','F','2017-05-15',1,'2018-04-13',1),(104,1003,'Cash','Chihuahua','M','2017-05-15',1,'2017-06-21',0),(105,1004,'Rocky','Poodle','M','2017-05-22',1,'2017-11-08',0),(106,1005,'Jasper','Beagle','M','2017-06-14',1,'2018-02-01',0),(107,1006,'Mia','Great Dane','F','2017-06-28',1,'2018-03-30',1),(108,1006,'Ranger','Siberian Husky','M','2017-07-09',1,'2018-04-13',1),(109,1005,'Grace','Pug','F','2017-08-22',1,'2017-12-11',0),(110,1007,'Chewy','Chow Chow','M','2017-09-06',1,'2017-09-30',0),(111,1002,'Holly','Yorkshire Terrier','F','2017-09-23',1,'2018-04-13',1),(112,1007,'Princess','Border Collie','F','2017-10-04',1,'2018-01-10',0),(113,1004,'Athena','Australian Shepherd','F','2017-11-13',1,'2018-04-13',1),(114,1006,'Zoe','Newfoundland','F','2017-12-20',1,'2018-04-13',1),(115,1007,'Otis','Bichon Frise','M','2018-01-18',0,NULL,0);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-15 21:52:40
