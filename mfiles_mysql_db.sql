-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: localhost    Database: mfiles_db
-- ------------------------------------------------------
-- Server version	5.7.13

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
-- Table structure for table `APP_USERS`
--

DROP TABLE IF EXISTS `APP_USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `APP_USERS` (
  `USER_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `USER_ENABLED` tinyint(1) DEFAULT NULL,
  `USERNAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `PASSWORD` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `UK_ap337s7dja9dglwl5ne1qsabt` (`USERNAME`),
  KEY `FK_9al6qwajsl5gc1mj0w10faagq` (`ROLE_ID`),
  CONSTRAINT `FK_9al6qwajsl5gc1mj0w10faagq` FOREIGN KEY (`ROLE_ID`) REFERENCES `APP_USER_ROLES` (`ROLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APP_USERS`
--

LOCK TABLES `APP_USERS` WRITE;
/*!40000 ALTER TABLE `APP_USERS` DISABLE KEYS */;
INSERT INTO `APP_USERS` VALUES (1,1,'SYS','$2a$10$3SQlFUhM7ZLmHm/K3i2Zx.P9DastYN9e7ytuKCdd/xJsIVrnJ9ZAu',1);
/*!40000 ALTER TABLE `APP_USERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `APP_USER_ROLES`
--

DROP TABLE IF EXISTS `APP_USER_ROLES`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `APP_USER_ROLES` (
  `ROLE_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `ROLE_DESC` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ROLE_NAME` varchar(75) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`ROLE_ID`),
  UNIQUE KEY `UK_2cxoixscxr04s0dg7mdgkwtjf` (`ROLE_NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `APP_USER_ROLES`
--

LOCK TABLES `APP_USER_ROLES` WRITE;
/*!40000 ALTER TABLE `APP_USER_ROLES` DISABLE KEYS */;
INSERT INTO `APP_USER_ROLES` VALUES (1,'System Administrator','ROLE_SYS_ADMIN'),(2,'User','ROLE_USER');
/*!40000 ALTER TABLE `APP_USER_ROLES` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `GENDER`
--

DROP TABLE IF EXISTS `GENDER`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `GENDER` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `GENDER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GENDER_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `GENDER`
--

LOCK TABLES `GENDER` WRITE;
/*!40000 ALTER TABLE `GENDER` DISABLE KEYS */;
/*!40000 ALTER TABLE `GENDER` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TITLE`
--

DROP TABLE IF EXISTS `TITLE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `TITLE` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TITLE_ID` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TITLE`
--

LOCK TABLES `TITLE` WRITE;
/*!40000 ALTER TABLE `TITLE` DISABLE KEYS */;
/*!40000 ALTER TABLE `TITLE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USER_ACCOUNT`
--

DROP TABLE IF EXISTS `USER_ACCOUNT`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USER_ACCOUNT` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CONTACT_ADDRESS` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `FIRST_NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `GENDER` bigint(20) DEFAULT NULL,
  `LAST_NAME` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TELEPHONE_NUMBER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `TITLE` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USER_ACCOUNT`
--

LOCK TABLES `USER_ACCOUNT` WRITE;
/*!40000 ALTER TABLE `USER_ACCOUNT` DISABLE KEYS */;
/*!40000 ALTER TABLE `USER_ACCOUNT` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-17 21:53:52
