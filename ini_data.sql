-- phpMyAdmin SQL Dump
-- version 4.4.13.1deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2016 at 03:39 PM
-- Server version: 5.6.30-0ubuntu0.15.10.1
-- PHP Version: 5.6.11-1ubuntu3.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `login_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `City`
--

CREATE TABLE IF NOT EXISTS `City` (
  `CityID` int(4) NOT NULL,
  `city_name` varchar(32) NOT NULL,
  `country_name` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `City`
--

INSERT INTO `City` (`CityID`, `city_name`, `country_name`) VALUES
(1, 'Colombo', 'Sri Lanka'),
(2, 'Gampaha', 'Sri Lanka'),
(3, 'Kandy', 'Sri Lanka'),
(4, 'Jaffna', 'Sri Lanka'),
(5, 'New Delhi', 'India'),
(6, 'Kulkatta', 'India'),
(7, 'Mumbai', 'India'),
(8, 'Chennai', 'India'),
(9, 'Tokyo', 'Japan'),
(10, 'Kyoto', 'Japan'),
(11, 'Osaka', 'Japan'),
(12, 'Nagoya', 'Japan');


-- --------------------------------------------------------

--
-- Table structure for table `Group`
--

CREATE TABLE IF NOT EXISTS `Group` (
  `GID` int(4) NOT NULL,
  `group` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Group`
--

INSERT INTO `Group` (`GID`, `group`) VALUES
(1, 'Administrator'),
(2, 'Customer care'),
(3, 'Translator');

-- --------------------------------------------------------

--
-- Table structure for table `Permission`
--

CREATE TABLE IF NOT EXISTS `Permission` (
  `PID` int(4) NOT NULL,
  `permission` varchar(32) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Permission`
--

INSERT INTO `Permission` (`PID`, `permission`) VALUES
(1, 'Add User'),
(2, 'Edit User'),
(3, 'Search User'),
(4, 'Delete User'),
(5, 'Translate'),
(6, 'Login');

-- --------------------------------------------------------

--
-- Table structure for table `Permission_Group`
--

CREATE TABLE IF NOT EXISTS `Permission_Group` (
  `PermissionPID` int(4) NOT NULL,
  `GroupGID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Permission_Group`
--

INSERT INTO `Permission_Group` (`PermissionPID`, `GroupGID`) VALUES
(1, 1),
(2, 1),
(3, 1),
(4, 1),
(6, 1);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE IF NOT EXISTS `User` (
  `UID` int(11) NOT NULL,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `f_name` varchar(32) NOT NULL,
  `l_name` varchar(32) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `country` varchar(32) NOT NULL,
  `e_mail` varchar(32) NOT NULL,
  `mobile` varchar(32) DEFAULT NULL,
  `city_id` int(4) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`UID`, `user_name`, `password`, `f_name`, `l_name`, `birth_date`, `country`, `e_mail`, `mobile`, `city_id`) VALUES
(1, 'tharindu', '6368ad93c9fa22ab35bf311477f74bd3', 'Tharindu', 'Abeyrathne', '1987-07-21', 'Japan', 'tharin@gmail.com', '+94112345678', 9),
(2, 'difna', '0bccf9431915dfab7cb8d13e4e6b3058', 'Difna', 'Jayamaha', '1991-03-08', 'Japan', 'difna@gmail.com', '+947723456789', 9);

-- --------------------------------------------------------

--
-- Table structure for table `User_Group`
--

CREATE TABLE IF NOT EXISTS `User_Group` (
  `UserUID` int(11) NOT NULL,
  `GroupGID` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `User_Group`
--

INSERT INTO `User_Group` (`UserUID`, `GroupGID`) VALUES
(1, 1),
(2, 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `City`
--
ALTER TABLE `City`
  ADD PRIMARY KEY (`CityID`);

--
-- Indexes for table `Group`
--
ALTER TABLE `Group`
  ADD PRIMARY KEY (`GID`);

--
-- Indexes for table `Permission`
--
ALTER TABLE `Permission`
  ADD PRIMARY KEY (`PID`);

--
-- Indexes for table `Permission_Group`
--
ALTER TABLE `Permission_Group`
  ADD PRIMARY KEY (`PermissionPID`,`GroupGID`),
  ADD KEY `FKPermission425876` (`PermissionPID`),
  ADD KEY `FKPermission536055` (`GroupGID`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`UID`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD KEY `FKUser85123` (`city_id`);

--
-- Indexes for table `User_Group`
--
ALTER TABLE `User_Group`
  ADD PRIMARY KEY (`UserUID`,`GroupGID`),
  ADD KEY `FKUser_Group864227` (`UserUID`),
  ADD KEY `FKUser_Group752343` (`GroupGID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `City`
--
ALTER TABLE `City`
  MODIFY `CityID` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `Group`
--
ALTER TABLE `Group`
  MODIFY `GID` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `Permission`
--
ALTER TABLE `Permission`
  MODIFY `PID` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `UID` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `Permission_Group`
--
ALTER TABLE `Permission_Group`
  ADD CONSTRAINT `FKPermission425876` FOREIGN KEY (`PermissionPID`) REFERENCES `Permission` (`PID`),
  ADD CONSTRAINT `FKPermission536055` FOREIGN KEY (`GroupGID`) REFERENCES `Group` (`GID`);

--
-- Constraints for table `User`
--
ALTER TABLE `User`
  ADD CONSTRAINT `FKUser85123` FOREIGN KEY (`city_id`) REFERENCES `City` (`CityID`);

--
-- Constraints for table `User_Group`
--
ALTER TABLE `User_Group`
  ADD CONSTRAINT `FKUser_Group752343` FOREIGN KEY (`GroupGID`) REFERENCES `Group` (`GID`),
  ADD CONSTRAINT `FKUser_Group864227` FOREIGN KEY (`UserUID`) REFERENCES `User` (`UID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
