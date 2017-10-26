-- MySQL dump 10.13  Distrib 5.7.19, for Linux (x86_64)
--
-- Host: localhost    Database: erp_details
-- ------------------------------------------------------
-- Server version	5.7.19-0ubuntu0.16.04.1

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
-- Dumping data for table `account_master`
--

LOCK TABLES `account_master` WRITE;
/*!40000 ALTER TABLE `account_master` DISABLE KEYS */;
INSERT INTO `account_master` VALUES (1,'test','aliasName',NULL,NULL,'kushal updated',NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `account_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `address_master`
--

LOCK TABLES `address_master` WRITE;
/*!40000 ALTER TABLE `address_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `category_master`
--

LOCK TABLES `category_master` WRITE;
/*!40000 ALTER TABLE `category_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `company_master`
--

LOCK TABLES `company_master` WRITE;
/*!40000 ALTER TABLE `company_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `customer_master`
--

LOCK TABLES `customer_master` WRITE;
/*!40000 ALTER TABLE `customer_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `erp_mstr`
--

LOCK TABLES `erp_mstr` WRITE;
/*!40000 ALTER TABLE `erp_mstr` DISABLE KEYS */;
INSERT INTO `erp_mstr` VALUES (1,1,1,'2017-10-27 01:03:36','2017-10-27 01:06:18','');
/*!40000 ALTER TABLE `erp_mstr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `organization_master`
--

LOCK TABLES `organization_master` WRITE;
/*!40000 ALTER TABLE `organization_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `permission_master`
--

LOCK TABLES `permission_master` WRITE;
/*!40000 ALTER TABLE `permission_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `product_master`
--

LOCK TABLES `product_master` WRITE;
/*!40000 ALTER TABLE `product_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `purchase_details_transaction`
--

LOCK TABLES `purchase_details_transaction` WRITE;
/*!40000 ALTER TABLE `purchase_details_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_details_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_master`
--

LOCK TABLES `role_master` WRITE;
/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `role_permission_mapping`
--

LOCK TABLES `role_permission_mapping` WRITE;
/*!40000 ALTER TABLE `role_permission_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `route_master`
--

LOCK TABLES `route_master` WRITE;
/*!40000 ALTER TABLE `route_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sale_detail`
--

LOCK TABLES `sale_detail` WRITE;
/*!40000 ALTER TABLE `sale_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `sale_detail_transaction`
--

LOCK TABLES `sale_detail_transaction` WRITE;
/*!40000 ALTER TABLE `sale_detail_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_detail_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_role_mapping`
--

LOCK TABLES `user_role_mapping` WRITE;
/*!40000 ALTER TABLE `user_role_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user_token_mapping`
--

LOCK TABLES `user_token_mapping` WRITE;
/*!40000 ALTER TABLE `user_token_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_token_mapping` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-10-27  1:13:27
