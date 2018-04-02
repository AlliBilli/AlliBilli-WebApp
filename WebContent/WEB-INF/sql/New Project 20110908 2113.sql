-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.57-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema allibilli
--

CREATE DATABASE IF NOT EXISTS allibilli;
USE allibilli;

--
-- Definition of table `accordians`
--

DROP TABLE IF EXISTS `accordians`;
CREATE TABLE `accordians` (
  `accdId` int(11) NOT NULL,
  `accdName` varchar(20) DEFAULT NULL,
  `panelId` int(11) DEFAULT NULL,
  `orderList` int(11) DEFAULT NULL,
  PRIMARY KEY (`accdId`) USING BTREE,
  KEY `PANELID` (`panelId`) USING BTREE,
  CONSTRAINT `Accordians_ibfk_1` FOREIGN KEY (`panelId`) REFERENCES `panels` (`panelId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `accordians`
--

/*!40000 ALTER TABLE `accordians` DISABLE KEYS */;
INSERT INTO `accordians` (`accdId`,`accdName`,`panelId`,`orderList`) VALUES 
 (1,'AlliBilli-Regular',1,1),
 (2,'India Govt',1,2),
 (3,'Movies Special',2,1),
 (4,'Students special',2,2);
/*!40000 ALTER TABLE `accordians` ENABLE KEYS */;


--
-- Definition of table `panels`
--

DROP TABLE IF EXISTS `panels`;
CREATE TABLE `panels` (
  `panelId` int(11) NOT NULL,
  `panelName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`panelId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `panels`
--

/*!40000 ALTER TABLE `panels` DISABLE KEYS */;
INSERT INTO `panels` (`panelId`,`panelName`) VALUES 
 (1,'LEFT'),
 (2,'RIGHT');
/*!40000 ALTER TABLE `panels` ENABLE KEYS */;


--
-- Definition of table `passwordmanager`
--

DROP TABLE IF EXISTS `passwordmanager`;
CREATE TABLE `passwordmanager` (
  `userId` int(11) NOT NULL,
  `title` varchar(20) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `uname` varchar(20) DEFAULT NULL,
  `decrptPwd` text
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passwordmanager`
--

/*!40000 ALTER TABLE `passwordmanager` DISABLE KEYS */;
/*!40000 ALTER TABLE `passwordmanager` ENABLE KEYS */;


--
-- Definition of table `treeelements`
--

DROP TABLE IF EXISTS `treeelements`;
CREATE TABLE `treeelements` (
  `eleId` int(11) NOT NULL,
  `text` varchar(30) NOT NULL,
  `accdId` int(11) DEFAULT '-1',
  `rootId` int(11) DEFAULT '-1',
  `leaf` tinyint(1) DEFAULT '1',
  `orderList` int(11) DEFAULT NULL,
  `eleUrl` varchar(100) DEFAULT NULL,
  `expanded` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`eleId`) USING BTREE,
  KEY `accdId` (`accdId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `treeelements`
--

/*!40000 ALTER TABLE `treeelements` DISABLE KEYS */;
INSERT INTO `treeelements` (`eleId`,`text`,`accdId`,`rootId`,`leaf`,`orderList`,`eleUrl`,`expanded`) VALUES 
 (1,'Eenadu',-1,9,1,1,'http://www.eenadu.net',1),
 (2,'Vaartha',-1,9,1,2,'http://www.vaarttha.com/index.asp',0),
 (3,'AndhraJyothi',-1,10,1,3,'http://www.andhrajyothy.com',0),
 (4,'Saakshi',-1,10,1,4,'http://www.sakshi.com',0),
 (5,'Dinamalar',-1,11,1,5,'http://www.dinamalar.com',0),
 (6,'Dinakaran',-1,11,1,6,'http://www.dinakaran.com',0),
 (7,'DeccanHerald',-1,12,1,7,'http://www.deccanherald.com/Content/Jan62009/update.asp',0),
 (8,'NewKerala',-1,12,1,8,'http://www.newkerala.com',0),
 (9,'News',1,-1,0,NULL,NULL,1),
 (10,'Etmnt',2,-1,0,NULL,NULL,1),
 (11,'test2',3,-1,0,NULL,NULL,0),
 (12,'test3',4,-1,0,NULL,NULL,1),
 (13,'subtree',1,-1,0,NULL,NULL,0),
 (14,'subsubTree',1,16,0,NULL,NULL,1),
 (15,'testleafNode',-1,14,1,9,NULL,1),
 (16,'subsubsub',1,9,0,NULL,NULL,1),
 (17,'lllll',1,16,1,NULL,NULL,0);
/*!40000 ALTER TABLE `treeelements` ENABLE KEYS */;


--
-- Definition of table `useraccordianmapper`
--

DROP TABLE IF EXISTS `useraccordianmapper`;
CREATE TABLE `useraccordianmapper` (
  `userId` int(11) NOT NULL,
  `accdId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `useraccordianmapper`
--

/*!40000 ALTER TABLE `useraccordianmapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `useraccordianmapper` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `userName` varchar(20) DEFAULT NULL,
  `password` varchar(15) DEFAULT NULL,
  `dspName` varchar(100) DEFAULT NULL,
  `emailId` varchar(50) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `timeZone` varchar(50) DEFAULT NULL,
  `createDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifyDate` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `pwdHint` varchar(100) DEFAULT NULL,
  `pwdAns` varchar(30) DEFAULT NULL,
  `dispSet` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;


--
-- Definition of table `usertreemapper`
--

DROP TABLE IF EXISTS `usertreemapper`;
CREATE TABLE `usertreemapper` (
  `userId` int(11) NOT NULL,
  `eleId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usertreemapper`
--

/*!40000 ALTER TABLE `usertreemapper` DISABLE KEYS */;
/*!40000 ALTER TABLE `usertreemapper` ENABLE KEYS */;


--
-- Definition of procedure `GetSandBoxData`
--

DROP PROCEDURE IF EXISTS `GetSandBoxData`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetSandBoxData`()
BEGIN

-- select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId and p.panelId = 1;

-- select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId and p.panelId = 2;



  SELECT * FROM TreeElements;

  -- select * from TreeElements t, Panels p, Accordians a where p.panelId = a.panelId and t.accdId = a.accdId;

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

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */ $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetUserSandBoxData`(IN userid VARCHAR(20))
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
