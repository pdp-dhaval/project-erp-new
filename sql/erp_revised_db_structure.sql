CREATE DATABASE  IF NOT EXISTS `erp_details` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `erp_details`;
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
-- Table structure for table `account_master`
--

DROP TABLE IF EXISTS `account_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `account_name` varchar(100) DEFAULT NULL,
  `alias_name` varchar(50) DEFAULT NULL,
  `opening_balance` double DEFAULT NULL,
  `balance_type` int(2) unsigned DEFAULT NULL,
  `contact_person_name` varchar(50) DEFAULT NULL,
  `mobile_number` varchar(12) DEFAULT NULL,
  `email_id` varchar(50) DEFAULT NULL,
  `phone_number` varchar(30) DEFAULT NULL,
  `fax_number` varchar(50) DEFAULT NULL,
  `gst_number` varchar(50) DEFAULT NULL,
  `pan_number` varchar(30) DEFAULT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_account_master_2_idx` (`user_id`),
  CONSTRAINT `fk_account_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_master`
--

LOCK TABLES `account_master` WRITE;
/*!40000 ALTER TABLE `account_master` DISABLE KEYS */;
INSERT INTO `account_master` VALUES (1,'test','aliasName',NULL,NULL,'kushal updated',NULL,NULL,NULL,NULL,NULL,NULL,1);
/*!40000 ALTER TABLE `account_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `address_master`
--

DROP TABLE IF EXISTS `address_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `address` varchar(250) DEFAULT NULL,
  `pincode` varchar(20) DEFAULT NULL,
  `city_id` bigint(20) unsigned DEFAULT NULL,
  `state_id` bigint(20) unsigned DEFAULT NULL,
  `country_id` bigint(20) unsigned DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_address_master_3_idx` (`org_id`),
  KEY `fk_address_master_2_idx` (`account_id`),
  KEY `fk_address_master_4_idx` (`user_id`),
  CONSTRAINT `fk_address_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_master_2` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_master_3` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_address_master_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address_master`
--

LOCK TABLES `address_master` WRITE;
/*!40000 ALTER TABLE `address_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `address_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category_master`
--

DROP TABLE IF EXISTS `category_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `category_name` varchar(50) NOT NULL DEFAULT 'NOT DEFINED',
  `org_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_category_master_2_idx` (`org_id`),
  CONSTRAINT `fk_category_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_category_master_2` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category_master`
--

LOCK TABLES `category_master` WRITE;
/*!40000 ALTER TABLE `category_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `category_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company_master`
--

DROP TABLE IF EXISTS `company_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `company_name` varchar(100) NOT NULL,
  `company_code` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_company_master_2_idx` (`org_id`),
  KEY `fk_company_master_2_idx1` (`account_id`),
  CONSTRAINT `fk_company_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_master_2` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_company_master_3` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company_master`
--

LOCK TABLES `company_master` WRITE;
/*!40000 ALTER TABLE `company_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `company_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_master`
--

DROP TABLE IF EXISTS `customer_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `route_id` bigint(20) unsigned NOT NULL,
  `customer_type` int(2) unsigned DEFAULT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_customer_master_2_idx` (`route_id`),
  KEY `fk_customer_master_3_idx` (`account_id`),
  KEY `fk_customer_master_4_idx` (`org_id`),
  CONSTRAINT `fk_customer_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_master_2` FOREIGN KEY (`route_id`) REFERENCES `route_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_master_3` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_master_4` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_master`
--

LOCK TABLES `customer_master` WRITE;
/*!40000 ALTER TABLE `customer_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erp_mstr`
--

DROP TABLE IF EXISTS `erp_mstr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `erp_mstr` (
  `erp_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `modified_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `modified_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`erp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erp_mstr`
--

LOCK TABLES `erp_mstr` WRITE;
/*!40000 ALTER TABLE `erp_mstr` DISABLE KEYS */;
INSERT INTO `erp_mstr` VALUES (1,1,1,'2017-10-27 01:03:36','2017-10-27 01:06:18','');
/*!40000 ALTER TABLE `erp_mstr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `organization_master`
--

DROP TABLE IF EXISTS `organization_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `organization_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_organization_master_2_idx` (`user_id`),
  KEY `fk_organization_master_3_idx` (`account_id`),
  CONSTRAINT `fk_organization_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_master_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_organization_master_3` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `organization_master`
--

LOCK TABLES `organization_master` WRITE;
/*!40000 ALTER TABLE `organization_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `organization_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_master`
--

DROP TABLE IF EXISTS `permission_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `name` varchar(100) NOT NULL DEFAULT 'NOT DEFINED',
  `org_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_permission_master_2_idx` (`org_id`),
  CONSTRAINT `fk_permission_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_permission_master_2` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_master`
--

LOCK TABLES `permission_master` WRITE;
/*!40000 ALTER TABLE `permission_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_master`
--

DROP TABLE IF EXISTS `product_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `product_code` varchar(50) DEFAULT NULL,
  `company_id` bigint(20) unsigned NOT NULL,
  `category_id` bigint(20) unsigned NOT NULL,
  `purchase_price` double NOT NULL,
  `product_description` varchar(250) DEFAULT NULL,
  `unit_quantity` bigint(20) unsigned DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_product_master_3_idx` (`category_id`),
  KEY `fk_product_master_4_idx` (`org_id`),
  KEY `fk_product_master_2_idx` (`company_id`),
  CONSTRAINT `fk_product_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_master_2` FOREIGN KEY (`company_id`) REFERENCES `company_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_master_3` FOREIGN KEY (`category_id`) REFERENCES `category_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_master_4` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_master`
--

LOCK TABLES `product_master` WRITE;
/*!40000 ALTER TABLE `product_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_detail`
--

DROP TABLE IF EXISTS `purchase_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `invoice_number` varchar(50) DEFAULT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `bill_number` varchar(50) DEFAULT NULL,
  `purchase_date` datetime DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `tax_id` int(2) unsigned DEFAULT NULL,
  `adjustment` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `updated_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchase_detail_3_idx` (`org_id`),
  KEY `fk_purchase_detail_2_idx` (`account_id`),
  KEY `fk_purchase_detail_4_idx` (`user_id`),
  CONSTRAINT `fk_purchase_detail_2` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_detail_3` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_detail_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_detail`
--

LOCK TABLES `purchase_detail` WRITE;
/*!40000 ALTER TABLE `purchase_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase_details_transaction`
--

DROP TABLE IF EXISTS `purchase_details_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase_details_transaction` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `purchase_detail_id` bigint(20) unsigned NOT NULL,
  `product_id` bigint(20) unsigned NOT NULL,
  `unit` int(20) unsigned DEFAULT NULL,
  `quantity` int(20) unsigned DEFAULT NULL,
  `free_quantity` int(20) unsigned DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `updated_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_purchase_details_transaction_2_idx` (`product_id`),
  KEY `fk_purchase_details_transaction_3_idx` (`org_id`),
  KEY `fk_purchase_details_transaction_4_idx` (`user_id`),
  KEY `fk_purchase_details_transaction_1_idx` (`purchase_detail_id`),
  CONSTRAINT `fk_purchase_details_transaction_1` FOREIGN KEY (`purchase_detail_id`) REFERENCES `purchase_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_details_transaction_2` FOREIGN KEY (`product_id`) REFERENCES `product_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_details_transaction_3` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_purchase_details_transaction_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_details_transaction`
--

LOCK TABLES `purchase_details_transaction` WRITE;
/*!40000 ALTER TABLE `purchase_details_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase_details_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_master`
--

DROP TABLE IF EXISTS `role_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `name` varchar(30) NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_role_master_2_idx` (`user_id`),
  CONSTRAINT `fk_role_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_master_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_master`
--

LOCK TABLES `role_master` WRITE;
/*!40000 ALTER TABLE `role_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role_permission_mapping`
--

DROP TABLE IF EXISTS `role_permission_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role_permission_mapping` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) unsigned NOT NULL,
  `permission_id` bigint(20) unsigned NOT NULL,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `updated_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_role_permission_mapping_2_idx` (`role_id`),
  KEY `fk_role_permission_mapping_3_idx` (`permission_id`),
  CONSTRAINT `fk_role_permission_mapping_2` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_role_permission_mapping_3` FOREIGN KEY (`permission_id`) REFERENCES `permission_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role_permission_mapping`
--

LOCK TABLES `role_permission_mapping` WRITE;
/*!40000 ALTER TABLE `role_permission_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `role_permission_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route_master`
--

DROP TABLE IF EXISTS `route_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route_master` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `route_name` varchar(100) NOT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_route_master_2_idx` (`org_id`),
  KEY `fk_route_master_3_idx` (`user_id`),
  CONSTRAINT `fk_route_master_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_master_2` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_route_master_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route_master`
--

LOCK TABLES `route_master` WRITE;
/*!40000 ALTER TABLE `route_master` DISABLE KEYS */;
/*!40000 ALTER TABLE `route_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_detail`
--

DROP TABLE IF EXISTS `sale_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_detail` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL,
  `bill_number` varchar(50) DEFAULT NULL,
  `invoice_number` varchar(50) DEFAULT NULL,
  `sales_date` datetime DEFAULT NULL,
  `payment_mode` int(10) unsigned DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `cgst` double DEFAULT NULL,
  `sgst` double DEFAULT NULL,
  `adjustment` double DEFAULT NULL,
  `net_amount` double DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `updated_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_sale_detail_2_idx` (`account_id`),
  KEY `fk_sale_detail_3_idx` (`org_id`),
  KEY `fk_sale_detail_4_idx` (`user_id`),
  CONSTRAINT `fk_sale_detail_2` FOREIGN KEY (`account_id`) REFERENCES `account_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_detail_3` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_detail_4` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_detail`
--

LOCK TABLES `sale_detail` WRITE;
/*!40000 ALTER TABLE `sale_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale_detail_transaction`
--

DROP TABLE IF EXISTS `sale_detail_transaction`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sale_detail_transaction` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sale_detail_id` bigint(20) unsigned NOT NULL,
  `product_id` bigint(20) unsigned NOT NULL,
  `unit` int(10) unsigned DEFAULT NULL,
  `quantity` bigint(20) unsigned DEFAULT NULL,
  `free_quantity` bigint(20) unsigned DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `rate` double DEFAULT NULL,
  `org_id` bigint(20) unsigned NOT NULL,
  `created_by` bigint(20) unsigned DEFAULT NULL,
  `updated_by` bigint(20) unsigned DEFAULT NULL,
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_date` datetime DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_sale_detail_transaction_3_idx` (`product_id`),
  KEY `fk_sale_detail_transaction_4_idx` (`org_id`),
  KEY `fk_sale_detail_transaction_5_idx` (`user_id`),
  KEY `fk_sale_detail_transaction_1_idx` (`sale_detail_id`),
  CONSTRAINT `fk_sale_detail_transaction_1` FOREIGN KEY (`sale_detail_id`) REFERENCES `sale_detail` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_detail_transaction_3` FOREIGN KEY (`product_id`) REFERENCES `product_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_detail_transaction_4` FOREIGN KEY (`org_id`) REFERENCES `organization_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_sale_detail_transaction_5` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale_detail_transaction`
--

LOCK TABLES `sale_detail_transaction` WRITE;
/*!40000 ALTER TABLE `sale_detail_transaction` DISABLE KEYS */;
/*!40000 ALTER TABLE `sale_detail_transaction` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `email` varchar(70) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `parent_id` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `otp_verified` bit(1) DEFAULT b'0',
  `email_verified` bit(1) DEFAULT b'0',
  PRIMARY KEY (`erp_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  KEY `fk_user_2_idx` (`parent_id`),
  CONSTRAINT `fk_user_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_2` FOREIGN KEY (`parent_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role_mapping`
--

DROP TABLE IF EXISTS `user_role_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role_mapping` (
  `erp_id` bigint(20) unsigned NOT NULL,
  `role_id` bigint(20) unsigned NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`erp_id`),
  KEY `fk_user_role_mapping_2_idx` (`role_id`),
  KEY `fk_user_role_mapping_3_idx` (`user_id`),
  CONSTRAINT `fk_user_role_mapping_1` FOREIGN KEY (`erp_id`) REFERENCES `erp_mstr` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_mapping_2` FOREIGN KEY (`role_id`) REFERENCES `role_master` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_role_mapping_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role_mapping`
--

LOCK TABLES `user_role_mapping` WRITE;
/*!40000 ALTER TABLE `user_role_mapping` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_role_mapping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_token_mapping`
--

DROP TABLE IF EXISTS `user_token_mapping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_token_mapping` (
  `id` bigint(20) unsigned NOT NULL,
  `token` varchar(100) NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `login_token` varchar(100) NOT NULL,
  `user_type` int(10) unsigned DEFAULT NULL,
  `is_active` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`),
  KEY `fk_user_token_mapping_1_idx` (`user_id`),
  CONSTRAINT `fk_user_token_mapping_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`erp_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

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

-- Dump completed on 2017-10-30 15:20:32
