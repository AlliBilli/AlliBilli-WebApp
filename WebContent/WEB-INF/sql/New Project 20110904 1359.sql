-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.91-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema quartzkumon
--

CREATE DATABASE IF NOT EXISTS quartzkumon;
USE quartzkumon;

--
-- Definition of table `Accordians`
--

DROP TABLE IF EXISTS `Accordians`;
CREATE TABLE `Accordians` (
  `accdId` int(11) NOT NULL,
  `accdName` varchar(20) default NULL,
  `panelId` int(11) default NULL,
  `orderList` int(11) default NULL,
  PRIMARY KEY  USING BTREE (`accdId`),
  KEY `PANELID` USING BTREE (`panelId`),
  CONSTRAINT `Accordians_ibfk_1` FOREIGN KEY (`PANELID`) REFERENCES `Panels` (`PANELID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Accordians`
--

/*!40000 ALTER TABLE `Accordians` DISABLE KEYS */;
INSERT INTO `Accordians` (`accdId`,`accdName`,`panelId`,`orderList`) VALUES 
 (1,'AlliBilli-Regular',1,1),
 (2,'India Govt',1,2),
 (3,'Movies Special',2,1),
 (4,'Students special',2,2);
/*!40000 ALTER TABLE `Accordians` ENABLE KEYS */;


--
-- Definition of table `Panels`
--

DROP TABLE IF EXISTS `Panels`;
CREATE TABLE `Panels` (
  `panelId` int(11) NOT NULL,
  `panelName` varchar(20) default NULL,
  PRIMARY KEY  USING BTREE (`panelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Panels`
--

/*!40000 ALTER TABLE `Panels` DISABLE KEYS */;
INSERT INTO `Panels` (`panelId`,`panelName`) VALUES 
 (1,'LEFT'),
 (2,'RIGHT');
/*!40000 ALTER TABLE `Panels` ENABLE KEYS */;


--
-- Definition of table `PasswordManager`
--

DROP TABLE IF EXISTS `PasswordManager`;
CREATE TABLE `PasswordManager` (
  `userId` int(11) NOT NULL,
  `title` varchar(20) default NULL,
  `description` varchar(50) default NULL,
  `url` varchar(100) default NULL,
  `uname` varchar(20) default NULL,
  `decrptPwd` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `PasswordManager`
--

/*!40000 ALTER TABLE `PasswordManager` DISABLE KEYS */;
/*!40000 ALTER TABLE `PasswordManager` ENABLE KEYS */;


--
-- Definition of table `TreeElements`
--

DROP TABLE IF EXISTS `TreeElements`;
CREATE TABLE `TreeElements` (
  `eleId` int(11) NOT NULL,
  `eleName` varchar(30) default NULL,
  `accdId` int(11) default NULL,
  `rootId` int(11) default NULL,
  `subEle` tinyint(1) default NULL,
  `orderList` int(11) default NULL,
  `eleUrl` varchar(100) NOT NULL,
  PRIMARY KEY  USING BTREE (`eleId`,`eleUrl`),
  KEY `accdId` USING BTREE (`accdId`),
  CONSTRAINT `TreeElements_ibfk_1` FOREIGN KEY (`ACCDID`) REFERENCES `Accordians` (`ACCDID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `TreeElements`
--

/*!40000 ALTER TABLE `TreeElements` DISABLE KEYS */;
INSERT INTO `TreeElements` (`eleId`,`eleName`,`accdId`,`rootId`,`subEle`,`orderList`,`eleUrl`) VALUES 
 (1,'Eenadu',1,NULL,NULL,1,'http://www.eenadu.net'),
 (2,'Vaartha',1,NULL,NULL,2,'http://www.vaarttha.com/index.asp'),
 (3,'AndhraJyothi',2,NULL,NULL,3,'http://www.andhrajyothy.com'),
 (4,'Saakshi',2,NULL,NULL,4,'http://www.sakshi.com'),
 (5,'Dinamalar',3,NULL,NULL,5,'http://www.dinamalar.com'),
 (6,'Dinakaran',3,NULL,NULL,6,'http://www.dinakaran.com'),
 (7,'DeccanHerald',4,NULL,NULL,7,'http://www.deccanherald.com/Content/Jan62009/update.asp'),
 (8,'NewKerala',4,NULL,NULL,8,'http://www.newkerala.com');
/*!40000 ALTER TABLE `TreeElements` ENABLE KEYS */;


--
-- Definition of table `UserAccordianMapper`
--

DROP TABLE IF EXISTS `UserAccordianMapper`;
CREATE TABLE `UserAccordianMapper` (
  `userId` int(11) NOT NULL,
  `accdId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UserAccordianMapper`
--

/*!40000 ALTER TABLE `UserAccordianMapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserAccordianMapper` ENABLE KEYS */;


--
-- Definition of table `UserTreeMapper`
--

DROP TABLE IF EXISTS `UserTreeMapper`;
CREATE TABLE `UserTreeMapper` (
  `userId` int(11) NOT NULL,
  `eleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `UserTreeMapper`
--

/*!40000 ALTER TABLE `UserTreeMapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `UserTreeMapper` ENABLE KEYS */;


--
-- Definition of table `Users`
--

DROP TABLE IF EXISTS `Users`;
CREATE TABLE `Users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(20) default NULL,
  `password` varchar(15) default NULL,
  `dspName` varchar(100) default NULL,
  `emailId` varchar(50) default NULL,
  `status` varchar(10) default NULL,
  `timeZone` varchar(50) default NULL,
  `createDate` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `modifyDate` timestamp NOT NULL default '0000-00-00 00:00:00',
  `pwdHint` varchar(100) default NULL,
  `pwdAns` varchar(30) default NULL,
  `dispSet` tinyint(1) default NULL,
  PRIMARY KEY  USING BTREE (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;


--
-- Definition of procedure `GetSandBoxData`
--

DROP PROCEDURE IF EXISTS `GetSandBoxData`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`quartzkumon`@`%` PROCEDURE `GetSandBoxData`()
BEGIN

-- select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId and p.panelId = 1;

-- select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId and p.panelId = 2;



  -- SELECT * FROM TreeElements;

  select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId;

  SELECT *
  FROM Accordians
  WHERE panelId IN (SELECT panelId FROM Panels WHERE panelName = "LEFT");

  SELECT *
  FROM Accordians
  WHERE panelId IN (SELECT panelId FROM Panels WHERE panelName = "RIGHT");

  SELECT * FROM Panels;




END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;

--
-- Definition of procedure `GetUserSandBoxData`
--

DROP PROCEDURE IF EXISTS `GetUserSandBoxData`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='' */ $$
CREATE DEFINER=`quartzkumon`@`%` PROCEDURE `GetUserSandBoxData`(IN userid VARCHAR(20))
BEGIN

  SELECT ele.eleId, eleName, ele.accdId, rootId, subEle, orderList
  FROM TreeElements ele, UserAccordianMapper accd , UserTreeMapper user
  WHERE ele.accdId = accd.accdId
  AND ele.eleId = user.eleId
  AND user.userId = userid;

  SELECT accd.accdId, accdName, panelId, orderList
  FROM Accordians accd, UserAccordianMapper user
  WHERE accd.accdId = user.accdId
  AND user.userId = userid
  AND panleId IN (SELECT panelId FROM Panels WHERE panelName = "LEFT");

  SELECT accd.accdId, accdName, panelId, orderList
  FROM Accordians accd, UserAccordianMapper user
  WHERE accd.accdId = user.accdId
  AND user.userId = userid
  AND panelId IN (SELECT panelId FROM Panels WHERE panelName = "RIGHT");

END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
