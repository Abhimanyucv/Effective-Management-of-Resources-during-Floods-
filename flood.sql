-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 16, 2020 at 06:02 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `flood`
--

-- --------------------------------------------------------

--
-- Table structure for table `cam_person`
--

CREATE TABLE IF NOT EXISTS `cam_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `relief_camp` varchar(255) NOT NULL,
  `person_name` varchar(255) NOT NULL,
  `aadhaar` varchar(255) NOT NULL,
  `date` date NOT NULL,
  `status` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `cam_person`
--

INSERT INTO `cam_person` (`id`, `relief_camp`, `person_name`, `aadhaar`, `date`, `status`) VALUES
(1, '1', 'test', '1002215', '2020-04-14', ''),
(2, '1', 'test 2', '222102012', '2020-04-14', '');

-- --------------------------------------------------------

--
-- Table structure for table `collection_point`
--

CREATE TABLE IF NOT EXISTS `collection_point` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `collection_point_name` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `logitude` varchar(100) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `collection_point`
--

INSERT INTO `collection_point` (`id`, `collection_point_name`, `location`, `username`, `password`, `latitude`, `logitude`, `status`) VALUES
(1, 'a', 'palarivattom', '', '', '', '', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) NOT NULL,
  `discription` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `item_name`, `discription`) VALUES
(1, 'Dress', ''),
(2, 'Rice', '');

-- --------------------------------------------------------

--
-- Table structure for table `relief_camp`
--

CREATE TABLE IF NOT EXISTS `relief_camp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `camp_name` varchar(100) NOT NULL,
  `location` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `logitude` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `relief_camp`
--

INSERT INTO `relief_camp` (`id`, `camp_name`, `location`, `username`, `password`, `latitude`, `logitude`) VALUES
(1, 'camp 1', 'palarivattom', 'test', 'test', '10.232', '7.232');

-- --------------------------------------------------------

--
-- Table structure for table `request`
--

CREATE TABLE IF NOT EXISTS `request` (
  `id` int(11) NOT NULL,
  `relief_camp` varchar(10) NOT NULL,
  `Discription` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `rescuer`
--

CREATE TABLE IF NOT EXISTS `rescuer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `Lname` varchar(200) NOT NULL,
  `phone_no` varchar(13) NOT NULL,
  `location` varchar(200) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `rescuer`
--

INSERT INTO `rescuer` (`id`, `username`, `password`, `name`, `Lname`, `phone_no`, `location`, `latitude`, `longitude`, `status`, `email`) VALUES
(1, 'q', '12345', 'q', '', '7012656981', '', '9.954526', '76.242434', 'q', 'q'),
(6, 'duusdu', 'puzifd', 'xjxjdj', 'jxjx', 'uddi', '', '10.006813991176774', '76.30555865702738', '', 'hddu'),
(7, 'duusdu', '12345', 'xjxjdj', 'jxjx', '8157988437', '', '10.006327664926161', '76.30535842735729', '', 'hddu'),
(8, 'test', 'test', 'test', 'test', 'test', '', '9.956005', '76.2415694', '', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `rescue_request`
--

CREATE TABLE IF NOT EXISTS `rescue_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) NOT NULL,
  `rid` int(11) NOT NULL,
  `name` varchar(200) NOT NULL,
  `phone` varchar(200) NOT NULL,
  `location` varchar(200) NOT NULL,
  `emergency` varchar(200) NOT NULL,
  `needs` varchar(200) NOT NULL,
  `hazards` varchar(200) NOT NULL,
  `ppl_count` varchar(10) NOT NULL,
  `pets_count` varchar(10) NOT NULL,
  `disabled_count` varchar(10) NOT NULL,
  `message` varchar(200) NOT NULL,
  `latitude` varchar(200) NOT NULL,
  `longitude` varchar(200) NOT NULL,
  `status` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `rescue_request`
--

INSERT INTO `rescue_request` (`id`, `uid`, `rid`, `name`, `phone`, `location`, `emergency`, `needs`, `hazards`, `ppl_count`, `pets_count`, `disabled_count`, `message`, `latitude`, `longitude`, `status`) VALUES
(1, 1, 1, 'q', '7012656981', 'test', 'test', 'First Aid, Food, ', 'Electrical, Others, ', '2', '0', '0', 'dcuuc', '9.95866645507198', '76.24296724921398', 'completed');

-- --------------------------------------------------------

--
-- Table structure for table `stock`
--

CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item` varchar(10) NOT NULL,
  `qty` varchar(10) NOT NULL,
  `colletion_point` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `stock`
--

INSERT INTO `stock` (`id`, `item`, `qty`, `colletion_point`) VALUES
(1, '1', '10', '1'),
(2, '2', '100', '1');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `Lname` varchar(200) NOT NULL,
  `phone_no` varchar(13) NOT NULL,
  `location` varchar(200) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `name`, `Lname`, `phone_no`, `location`, `latitude`, `longitude`, `status`, `email`) VALUES
(1, 'q', '12345', 'q', '', '7012656981', '', '10.006327664926161', '76.30535842735729', 'q', 'q'),
(6, 'duusdu', 'puzifd', 'xjxjdj', 'jxjx', 'uddi', '', '10.006813991176774', '76.30555865702738', '', 'hddu'),
(7, 'duusdu', '12345', 'xjxjdj', 'jxjx', '8157988437', '', '10.006327664926161', '76.30535842735729', '', 'hddu'),
(8, 'test', 'test', 'test', 'test', 'test', '', '9.956005', '76.2415694', '', 'test'),
(9, 'test', 'test', 'test 1', 'test 1', '7012656981', '', '9.98599797527654', '76.30638755651009', '', 'abin.ck.9@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle`
--

CREATE TABLE IF NOT EXISTS `vehicle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vechile_id` varchar(255) NOT NULL,
  `name` varchar(200) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `vehicle`
--

INSERT INTO `vehicle` (`id`, `vechile_id`, `name`, `username`, `password`) VALUES
(1, '1', '', 'test', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_stock`
--

CREATE TABLE IF NOT EXISTS `vehicle_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `vechile_id` varchar(255) NOT NULL,
  `item` varchar(255) NOT NULL,
  `qty` varchar(255) NOT NULL,
  `relief_camp` varchar(255) NOT NULL,
  `status` varchar(10) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `vehicle_stock`
--

INSERT INTO `vehicle_stock` (`id`, `vechile_id`, `item`, `qty`, `relief_camp`, `status`) VALUES
(1, '1', '1', '20', '1', ''),
(2, '1', '2', '25', '1', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
