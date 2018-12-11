-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 11, 2018 at 10:09 AM
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
(1, 'Bulevar Dzordza Vasingtona 92', 'Podgoricaa', 'synergysuite@synergysuite.com', 'SynergySuiteP1', 'synergysuite', 1),
(2, 'Belvederska 22', 'Podgorica', 'exampleemail@gmail.com', 'SynergySuiteP2', 'belvederska123', 1),
(3, '3', '4', '1', '25', '5', 1),
(5, 'Belvederska 22', 'Podgorica', 'Name', 'Mail', 'belvederska123', 1),
(6, '22', '22', '22', '22', '22', 1),
(8, '4', '2', '3', '1', '5', 1),
(12, '4', '2', '5', '3', '1', 1),
(13, 'admin', 'admin', 'admin@synergysuite.com', 'admin', 'admin', 1),
(14, 'admi', 'adm', 'a', 'adn', 'admin', 1),
(15, '4564', '456456', '645456', '456456', '123', 1),
(16, '3244', '213', '123', '44353', '111', 0),
(18, '123435', '12435465', '132435465', 'asd', '123', 0),
(19, '3131', '1321321', '31232132', '3213213131333333333', '111', 0),
(20, '45', '434', '341', 'a', '45', 0),
(25, '323', '323', 'aa', '32', '12', 0),
(26, '12', '12', '12', '122', '12', 1);

-- --------------------------------------------------------

--
-- Table structure for table `managers`
--

CREATE TABLE `managers` (
  `id` int(11) NOT NULL,
  `name` varchar(25) NOT NULL,
  `last_name` varchar(25) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(25) NOT NULL,
  `fk_branch_id` int(11) NOT NULL,
  `active` int(11) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `managers`
--

INSERT INTO `managers` (`id`, `name`, `last_name`, `email`, `password`, `fk_branch_id`, `active`) VALUES
(1, 'Anton', 'Djokaj', 'antondjokaj@synergysuite.com', 'synergysuite123', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `shifts`
--

CREATE TABLE `shifts` (
  `id` int(11) NOT NULL,
  `start_shift` time NOT NULL,
  `end_shift` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `shifts`
--

INSERT INTO `shifts` (`id`, `start_shift`, `end_shift`) VALUES
(1, '08:00:00', '16:00:00'),
(2, '16:00:00', '00:00:00'),
(3, '00:00:00', '08:00:00');

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
  `active` int(11) NOT NULL DEFAULT '1',
  `branch_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workers`
--

INSERT INTO `workers` (`id`, `fk_branc_id`, `name`, `last_name`, `email`, `password`, `active`, `branch_name`) VALUES
(1, 2, 'Antonn', 'Djokaj', 'anton.dj@synergysuite.com', 'anton', 1, NULL),
(2, 1, 'Mirko', 'Tomovic', 'mirko.tomovic@synergysuite.com', 'mirko', 0, NULL),
(3, 1, '123', '132', '1232', '1', 1, NULL),
(4, 1, 'Andjela', 'Milic', 'aldjela.milic@gmail.com', 'andjela123', 0, NULL),
(5, 1, 'Sava', 'Softic', 'sava123@gmail.com', 'sava123', 1, NULL),
(6, 2, 'Milica', 'Milacic', 'milicam@gmail.com', 'milica1231', 1, NULL),
(7, 3, '1', '12', '1', '1', 0, NULL),
(8, 3, '1', '1', '1', '1', 1, NULL),
(9, 3, '23', '23', '23', '2', 1, NULL),
(11, 1, '555', '555', '55', '55', 0, NULL),
(12, 3, '122', '12', '12', '12', 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `worker_shift`
--

CREATE TABLE `worker_shift` (
  `id` int(11) NOT NULL,
  `clock_in` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `clock_out` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  `worker_id` int(11) NOT NULL,
  `shift_id` int(11) NOT NULL,
  `branch_id` int(11) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `worker_shift`
--

INSERT INTO `worker_shift` (`id`, `clock_in`, `clock_out`, `worker_id`, `shift_id`, `branch_id`, `date`) VALUES
(8, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 1, 1, '2018-12-12'),
(9, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-12'),
(10, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 1, 1, '2018-12-12'),
(11, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-12'),
(12, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 2, 1, '2018-12-12'),
(13, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 6, 2, 1, '2018-12-12'),
(14, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 3, 1, '2018-12-12'),
(15, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 11, 3, 1, '2018-12-12'),
(16, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-12'),
(17, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-12'),
(18, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-12'),
(19, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-12'),
(20, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 2, 1, '2018-12-12'),
(21, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 6, 2, 1, '2018-12-12'),
(22, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 3, 1, '2018-12-12'),
(23, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 3, 1, '2018-12-12'),
(24, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-22'),
(25, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-22'),
(26, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 2, 1, '2018-12-22'),
(27, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 6, 2, 1, '2018-12-22'),
(28, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 3, 1, '2018-12-22'),
(29, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 3, 1, '2018-12-22'),
(30, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 1, 1, '2018-12-10'),
(31, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-10'),
(32, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-10'),
(33, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-12'),
(34, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-13'),
(35, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-14'),
(36, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-15'),
(37, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-16'),
(38, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-18'),
(39, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 1, 1, '2018-12-12'),
(40, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 3, 1, 1, '2018-12-12'),
(41, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-11'),
(42, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 5, 1, 1, '2018-12-11'),
(43, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 2, 1, 1, '2018-12-27'),
(44, '0000-00-00 00:00:00', '0000-00-00 00:00:00', 4, 1, 1, '2018-12-02');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `branches`
--
ALTER TABLE `branches`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `name` (`name`);

--
-- Indexes for table `managers`
--
ALTER TABLE `managers`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_branch_id` (`fk_branch_id`);

--
-- Indexes for table `shifts`
--
ALTER TABLE `shifts`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `workers`
--
ALTER TABLE `workers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_branc_id` (`fk_branc_id`);

--
-- Indexes for table `worker_shift`
--
ALTER TABLE `worker_shift`
  ADD PRIMARY KEY (`id`),
  ADD KEY `worker_id` (`worker_id`),
  ADD KEY `shift_id` (`shift_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branches`
--
ALTER TABLE `branches`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT for table `managers`
--
ALTER TABLE `managers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `shifts`
--
ALTER TABLE `shifts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `workers`
--
ALTER TABLE `workers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `worker_shift`
--
ALTER TABLE `worker_shift`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `managers`
--
ALTER TABLE `managers`
  ADD CONSTRAINT `managers_ibfk_1` FOREIGN KEY (`fk_branch_id`) REFERENCES `branches` (`id`);

--
-- Constraints for table `workers`
--
ALTER TABLE `workers`
  ADD CONSTRAINT `workers_ibfk_1` FOREIGN KEY (`fk_branc_id`) REFERENCES `branches` (`id`);

--
-- Constraints for table `worker_shift`
--
ALTER TABLE `worker_shift`
  ADD CONSTRAINT `worker_shift_ibfk_1` FOREIGN KEY (`worker_id`) REFERENCES `workers` (`id`),
  ADD CONSTRAINT `worker_shift_ibfk_2` FOREIGN KEY (`shift_id`) REFERENCES `shifts` (`id`),
  ADD CONSTRAINT `worker_shift_ibfk_3` FOREIGN KEY (`branch_id`) REFERENCES `branches` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
