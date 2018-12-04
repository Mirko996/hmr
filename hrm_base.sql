-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2018 at 01:33 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hrm_base`
--

-- --------------------------------------------------------

--
-- Table structure for table `branches`
--

CREATE TABLE `branches` (
  `id` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `city` varchar(20) NOT NULL,
  `email` varchar(40) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `active` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `branches`
--

INSERT INTO `branches` (`id`, `address`, `city`, `email`, `name`, `password`, `active`) VALUES
(1, 'Bulevar Dzordza Vasingtona 92', 'Podgorica', 'synergysuite@synergysuite.com', 'SynergySuiteP1', 'synergysuite', 1),
(2, 'Belvederska 22', 'Podgorica', 'exampleemail@gmail.com', 'SynergySuiteP2', 'belvederska123', 1);

-- --------------------------------------------------------

--
-- Table structure for table `shifts`
--

CREATE TABLE `shifts` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `worker_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `workers`
--

CREATE TABLE `workers` (
  `id` int(11) NOT NULL,
  `fk_branc_id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `active` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workers`
--

INSERT INTO `workers` (`id`, `fk_branc_id`, `name`, `last_name`, `email`, `password`, `active`) VALUES
(1, 1, 'Anton', 'Djokaj', 'anton.djokaj@synergysuite.com', 'anton', 1),
(2, 1, 'Mirko', 'Tomovic', 'mirko.tomovic@synergysuite.com', 'mirko', 1),
(3, 1, 'Milan', 'Maric', 'milan.maric@gmail.com', 'milan123', 1),
(4, 1, 'Andjela', 'Milic', 'aldjela.milic@gmail.com', 'andjela123', 1),
(5, 1, 'Sava', 'Softic', 'sava123@gmail.com', 'sava123', 1),
(6, 1, 'Milica', 'Milacic', 'milicam@gmail.com', 'milica123', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shifts`
--
ALTER TABLE `shifts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `worker_id` (`worker_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- Indexes for table `workers`
--
ALTER TABLE `workers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_branc_id` (`fk_branc_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `shifts`
--
ALTER TABLE `shifts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `workers`
--
ALTER TABLE `workers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `shifts`
--
ALTER TABLE `shifts`
  ADD CONSTRAINT `shifts_ibfk_1` FOREIGN KEY (`worker_id`) REFERENCES `workers` (`id`),
  ADD CONSTRAINT `shifts_ibfk_2` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`);

--
-- Constraints for table `workers`
--
ALTER TABLE `workers`
  ADD CONSTRAINT `workers_ibfk_1` FOREIGN KEY (`fk_branc_id`) REFERENCES `branches` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
