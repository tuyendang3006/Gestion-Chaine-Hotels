-- MySQL dump 10.13  Distrib 8.0.11, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: gestion_hotels
-- ------------------------------------------------------
-- Server version	8.0.11

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `categories` (
  `idcategories` int(11) NOT NULL,
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`idcategories`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'La chambre double'),(2,'La chambre twin'),(3,'La chambre single'),(4,'La chambre triple'),(5,'La chambre quadruple');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chambres`
--

DROP TABLE IF EXISTS `chambres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `chambres` (
  `idchambres` int(11) NOT NULL,
  `telChambre` varchar(45) NOT NULL,
  `etatChambre` varchar(45) NOT NULL,
  `idcategories` int(11) NOT NULL,
  `idhotels` int(11) NOT NULL,
  PRIMARY KEY (`idchambres`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chambres`
--

LOCK TABLES `chambres` WRITE;
/*!40000 ALTER TABLE `chambres` DISABLE KEYS */;
INSERT INTO `chambres` VALUES (1,'0494943847','En_vente',1,1),(2,'0283773636','Confirmée',2,2),(3,'0389376535','Occupée',3,3),(4,'0384746363','En_vente',4,1),(5,'0883773635','Bloquée',5,2),(6,'0383474653','Bloquée',1,3),(7,'0936524344','Confirmée',2,1),(8,'0928276524','Confirmée',3,2),(9,'0938762524','En_vente',4,3),(10,'0936254232','En_vente',5,1),(11,'0997171616','Confirmée',1,1),(12,'0827265242','Ocuppée',2,2),(13,'0982662552','Non_confirmée',3,3),(14,'0927726255','En_vente',2,2),(15,'0928726626','En vente',4,5),(16,'0986544432','En_vente',1,3),(17,'0972662552','En_vente',2,4),(18,'0982662655','En_vente',4,3),(19,'0928272662','En_vente',2,3),(20,'0982772772','Confirmée',3,4),(21,'0927772662','Occupée',1,1),(22,'0987262525','Occupée',2,2),(23,'0987625252','En_vente',3,1),(24,'0928276162','En vente',4,2),(25,'0902928282','En vente',5,3),(26,'0928727626','Confirmée',1,4),(27,'0929282882','En vente',2,1),(28,'0928272629','Occupée',3,2),(29,'0929827726','En vente',4,3),(30,'0928272772','Occupée',1,3);
/*!40000 ALTER TABLE `chambres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classes`
--

DROP TABLE IF EXISTS `classes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `classes` (
  `nbetoile` int(11) NOT NULL,
  PRIMARY KEY (`nbetoile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classes`
--

LOCK TABLES `classes` WRITE;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` VALUES (1),(2),(3),(4),(5);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clients`
--

DROP TABLE IF EXISTS `clients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `clients` (
  `idclients` int(11) NOT NULL AUTO_INCREMENT,
  `nomClient` varchar(45) NOT NULL,
  `prenomClient` varchar(45) NOT NULL,
  `adrClient` varchar(45) NOT NULL,
  `villeClient` varchar(45) NOT NULL,
  `CPClient` int(11) NOT NULL,
  `paysClient` varchar(45) NOT NULL,
  `telClient` varchar(45) NOT NULL,
  `emailClient` varchar(45) NOT NULL,
  PRIMARY KEY (`idclients`),
  UNIQUE KEY `idclients_UNIQUE` (`idclients`)
) ENGINE=InnoDB AUTO_INCREMENT=1993 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clients`
--

LOCK TABLES `clients` WRITE;
/*!40000 ALTER TABLE `clients` DISABLE KEYS */;
INSERT INTO `clients` VALUES (1,'Chang','Jun','12 Rue Léon','Marseille',13002,'France','0617272727','changjun@gmail.com'),(2,'Tan','Hana','20 Avenue Napoléon','Paris',75243,'France','0928625424','hanatan@gmail.com'),(3,'Ren','Kao','12 YY Street','Tokyo',20283,'Japon','0827266535','kao@hotmail.fr'),(4,'Smith','Rooney','23 Lamp Street','London',62300,'Anglette','0288375432','rooney123@gmail.com'),(5,'Kang','Loa','20 Rue Papa ','Cannes',12309,'France','0928736363','kang@gmail.com'),(6,'Chen','Dao','34 Rue Lyon','Lyon',21000,'France','0338465534','chendao@hotmail.com'),(7,'Le','Kha','19 Avenue AA','Paris',72652,'France','0333933333','lekha@gmail.com'),(9,'Yang','Edward','12 Rue Igmar','Cannes',12344,'France','0986528722','edwardfilms@gmail.com'),(10,'LY','An','12_AHH_Street','New_York',20291,'Américain','0298262626','lyanfilms@.tw'),(11,'Caméron','Jame','20_AOA_Street','Log_Angeles',23828,'Américain','0928282100','jamecamaron@hollywood.com'),(12,'Tsai','Ming_Liang','12_Nan_Yang','Taipei',20921,'Taiwan','092772716','tsaicinema@.tw'),(13,'Feguson','Alex','28_Odl_Traffort','Manchester',20229,'Anglette','02992822','alexferguson@gmail.com'),(14,'Jia','Zhang','297_Tsing_Hua','Bejing',2928,'Chine','092882727','jiazhangjtc@.cn'),(15,'Hou','Hsiao_Hsien','29_Hua_Nan','Taipei',2992,'Taiwan','+9209172626','houhsiaohsien.cine@.tw'),(16,'Messi','Léo','290 Rue Catalanne','Baccelone',20309,'Espagne','0292875528','leomessifb@hotmail.com'),(17,'De Gea','David','1 Avenue Alentico','Marrid',20918,'Espagne','0283753553','david1190@united.mu'),(18,'Beckham','David','12 Trafford Street','London',12082,'Anglette','0288272552','beckham.united@gmail.com'),(19,'Gotze','Mario','14 Dabun Street','Munich',28362,'Gemany','0927726622','mario.gotze@yahoo.com'),(20,'Pogba','Paul','20 Traverse Pasteur','Paris',75225,'France','096Z557626','paul2344@gmail.com'),(26,'Yang','Xuong','290_Rue_Patron','Paris',76202,'France','0929272661','yangxuang@gmail.com');
/*!40000 ALTER TABLE `clients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consommations`
--

DROP TABLE IF EXISTS `consommations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `consommations` (
  `idconsommations` int(11) NOT NULL,
  `dateConsommation` datetime NOT NULL,
  `heureConsommation` int(11) DEFAULT NULL,
  `montant` int(11) NOT NULL,
  `idclients` int(11) NOT NULL,
  `idprestations` int(11) NOT NULL,
  PRIMARY KEY (`idconsommations`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consommations`
--

LOCK TABLES `consommations` WRITE;
/*!40000 ALTER TABLE `consommations` DISABLE KEYS */;
INSERT INTO `consommations` VALUES (1,'2019-04-29 13:00:00',1,25,5,2),(2,'2019-04-29 17:00:00',1,30,5,4),(3,'2019-04-30 18:00:00',1,15,5,8),(4,'2020-05-10 08:00:00',1,20,12,1),(5,'2020-05-11 00:00:00',1,20,12,1),(6,'2020-05-12 00:00:00',1,20,12,1),(7,'2020-05-01 06:00:00',1,20,5,1),(8,'2020-05-23 01:00:00',1,30,3,4),(9,'2020-05-23 20:00:00',1,50,3,4),(10,'2020-05-24 00:00:00',4,10,3,10),(11,'2020-05-25 17:00:00',3,21,9,7),(12,'2020-05-25 18:00:00',1,20,9,5),(13,'2020-05-25 23:00:00',1,30,3,4),(14,'2020-05-26 13:00:00',1,20,9,2),(15,'2020-05-26 17:00:00',2,14,2,7),(16,'2020-05-26 19:00:00',1,25,3,4),(17,'2020-05-26 20:00:00',3,12,2,9),(18,'2020-05-26 23:00:00',1,50,3,6),(19,'2020-05-26 00:00:00',1,30,9,6),(30,'2020-05-27 00:00:00',1,20,3,3),(31,'2020-06-26 00:00:00',1,12,3,3),(38,'2020-05-27 00:00:00',2,20,2,10),(41,'2020-05-28 00:00:00',1,20,3,1),(43,'2020-05-26 00:00:00',2,20,2,8),(45,'2020-05-27 00:00:00',2,28,2,8),(46,'2020-05-27 00:00:00',1,10,2,9);
/*!40000 ALTER TABLE `consommations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hotels`
--

DROP TABLE IF EXISTS `hotels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `hotels` (
  `idhotels` int(11) NOT NULL,
  `nomHotel` varchar(45) NOT NULL,
  `adrHotel` varchar(45) NOT NULL,
  `CPHotel` int(11) NOT NULL,
  `telHotel` varchar(45) NOT NULL,
  `nbetoile` int(11) NOT NULL,
  PRIMARY KEY (`idhotels`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hotels`
--

LOCK TABLES `hotels` WRITE;
/*!40000 ALTER TABLE `hotels` DISABLE KEYS */;
INSERT INTO `hotels` VALUES (1,'SunShine','18 Avenue Robert, Marseille',13002,'04282837383',3),(2,'ABC Kannes','12 Rue Cacao, Paris',75272,'04829292822',4),(3,'Cinéma AE','122 Avenue National, Cannes',15920,'04837363636',5),(4,'P&P Love','98 Traverser Amondie, Toulon',14038,'04837262552',3),(5,'TWA MM','82 Traverse Lana',27388,'04837524353',5);
/*!40000 ALTER TABLE `hotels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offre`
--

DROP TABLE IF EXISTS `offre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `offre` (
  `idprestations` int(11) NOT NULL,
  `idhotels` int(11) NOT NULL,
  `prixPrestation` int(11) NOT NULL,
  PRIMARY KEY (`idprestations`,`idhotels`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offre`
--

LOCK TABLES `offre` WRITE;
/*!40000 ALTER TABLE `offre` DISABLE KEYS */;
INSERT INTO `offre` VALUES (1,1,17),(1,2,20),(1,3,25),(1,4,20),(1,5,18),(2,1,20),(2,2,25),(2,3,35),(2,4,20),(2,5,25),(3,1,6),(3,2,8),(3,3,10);
/*!40000 ALTER TABLE `offre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestations`
--

DROP TABLE IF EXISTS `prestations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `prestations` (
  `idprestations` int(11) NOT NULL,
  `designationPrest` varchar(45) NOT NULL,
  PRIMARY KEY (`idprestations`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestations`
--

LOCK TABLES `prestations` WRITE;
/*!40000 ALTER TABLE `prestations` DISABLE KEYS */;
INSERT INTO `prestations` VALUES (1,'Petit déjeuner'),(2,'Déjeuner'),(3,'Beer'),(4,'Diner'),(5,'Fruit'),(6,'Gateau'),(7,'Piscin'),(8,'Téléphone'),(9,'Air Conditionaire'),(10,'Télévision');
/*!40000 ALTER TABLE `prestations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservations`
--

DROP TABLE IF EXISTS `reservations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reservations` (
  `idreservations` int(11) NOT NULL,
  `dateDebut` datetime NOT NULL,
  `dateFin` datetime DEFAULT NULL,
  `datePayeArrhes` datetime NOT NULL,
  `montantArrhes` int(11) NOT NULL,
  `idclients` int(11) NOT NULL,
  `idchambres` int(11) NOT NULL,
  PRIMARY KEY (`idreservations`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservations`
--

LOCK TABLES `reservations` WRITE;
/*!40000 ALTER TABLE `reservations` DISABLE KEYS */;
INSERT INTO `reservations` VALUES (1,'2020-06-19 00:00:00','2020-06-22 00:00:00','2020-05-19 00:00:00',260,1,1),(2,'2020-06-01 00:00:00','2020-06-20 00:00:00','2020-05-20 00:00:00',1500,2,2),(3,'2020-06-15 00:00:00','2020-06-20 00:00:00','2020-05-21 00:00:00',750,3,3),(4,'2020-06-11 00:00:00','2020-06-15 00:00:00','2020-05-24 00:00:00',720,5,10),(5,'2020-06-11 12:00:00','2020-06-12 10:00:00','2020-05-25 00:00:00',120,8,1),(6,'2020-06-06 00:00:00','2020-06-10 00:00:00','2020-05-26 00:00:00',560,5,9),(7,'2020-06-11 00:00:00','2020-06-16 00:00:00','2020-05-25 00:00:00',620,11,11),(8,'2020-10-20 00:00:00','2020-10-22 00:00:00','2020-05-25 00:00:00',560,6,17),(9,'2019-01-11 11:00:00','2019-01-30 11:00:00','2019-01-11 11:00:00',2300,3,7),(10,'2016-12-20 11:20:20','2017-01-11 11:00:00','2016-11-20 11:00:00',3220,5,11),(11,'2017-06-11 11:30:00','2017-07-01 11:00:00','2017-06-01 23:00:00',2300,2,20),(12,'2018-01-11 11:00:00','2018-02-11 11:00:00','2018-01-01 11:00:00',3200,5,5),(13,'2019-04-29 11:00:00','2019-05-01 11:00:00','2019-04-01 11:00:00',320,5,10),(14,'2020-05-21 00:00:00','2020-05-31 00:00:00','2020-05-21 00:00:00',1300,10,27),(15,'2020-05-09 00:00:00','2020-05-29 00:00:00','2020-05-21 00:00:00',2390,12,29),(16,'2020-05-26 00:00:00','2020-05-30 00:00:00','2020-05-26 00:00:00',560,2,28),(17,'2020-05-22 00:00:00','2020-05-29 22:00:00','2020-05-22 00:00:00',750,3,25),(18,'2020-05-19 00:00:00','2020-06-11 11:00:00','2020-05-19 00:00:00',2308,9,23),(19,'2020-05-27 00:00:00','2020-05-29 00:00:00','2020-05-27 00:00:00',240,11,22),(20,'2020-05-26 00:00:00','2020-05-31 00:00:00','2020-05-21 00:00:00',560,14,21),(21,'2020-05-20 20:19:20','2020-05-26 00:00:00','2020-05-20 20:19:20',560,7,7),(22,'2020-05-21 20:19:20','2020-05-26 00:00:00','2020-05-20 20:19:20',490,8,9),(23,'2020-05-19 20:19:20','2020-05-26 00:00:00','2020-05-19 20:19:20',690,15,10),(24,'2020-05-11 20:19:20','2020-05-26 00:00:00','2020-05-11 20:19:20',1620,13,29),(26,'2020-06-27 00:00:00','2020-06-28 00:00:00','2020-06-20 00:00:00',100,19,2),(27,'2020-05-16 00:00:00','2020-05-27 00:00:00','2020-05-17 00:00:00',1400,16,20),(40,'2020-06-27 00:00:00','2020-06-30 00:00:00','2020-05-27 00:00:00',280,16,26),(50,'2020-05-26 00:00:00','2020-05-26 00:00:00','2020-05-25 00:00:00',120,16,27);
/*!40000 ALTER TABLE `reservations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tarifier`
--

DROP TABLE IF EXISTS `tarifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tarifier` (
  `idcategories` int(11) NOT NULL,
  `nbetoile` int(11) NOT NULL,
  `tarifUnitaire` int(11) NOT NULL,
  PRIMARY KEY (`idcategories`,`nbetoile`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarifier`
--

LOCK TABLES `tarifier` WRITE;
/*!40000 ALTER TABLE `tarifier` DISABLE KEYS */;
INSERT INTO `tarifier` VALUES (1,3,80),(1,4,120),(1,5,200),(2,2,200),(2,4,300),(2,5,500);
/*!40000 ALTER TABLE `tarifier` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-28 14:40:47
