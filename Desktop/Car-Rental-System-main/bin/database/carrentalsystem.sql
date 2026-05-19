-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 19 مايو 2026 الساعة 21:05
-- إصدار الخادم: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `carrentalsystem`
--

-- --------------------------------------------------------

--
-- بنية الجدول `backuplog`
--

CREATE TABLE `backuplog` (
  `Backup_ID` int(11) NOT NULL,
  `BackupDate` datetime NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `User_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `branch`
--

CREATE TABLE `branch` (
  `Branch_ID` int(11) NOT NULL,
  `BranchName` varchar(50) NOT NULL,
  `Location` varchar(150) NOT NULL,
  `Phone` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `car`
--

CREATE TABLE `car` (
  `Car_ID` int(11) NOT NULL,
  `PlateNumber` varchar(20) NOT NULL,
  `ChassisNumber` varchar(50) NOT NULL,
  `Brand` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Year` int(11) NOT NULL,
  `Color` varchar(30) NOT NULL,
  `Status` varchar(30) NOT NULL,
  `DailyPrice` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `car`
--

INSERT INTO `car` (`Car_ID`, `PlateNumber`, `ChassisNumber`, `Brand`, `Model`, `Year`, `Color`, `Status`, `DailyPrice`) VALUES
(1, 'BMW-001', 'CHS-BMW-1001', 'BMW', 'M4', 2024, 'Black', 'Available', 120.00),
(2, 'AUDI-002', 'CHS-AUDI-1002', 'Audi', 'RS7', 2024, 'Gray', 'Available', 150.00),
(3, 'MER-003', 'CHS-MER-1003', 'Mercedes', 'C63', 2023, 'White', 'Available', 170.00),
(4, 'POR-004', 'CHS-POR-1004', 'Porsche', '911', 2024, 'Yellow', 'Available', 250.00),
(5, 'LAM-005', 'CHS-LAM-1005', 'Lamborghini', 'Huracan', 2024, 'Green', 'Available', 400.00),
(6, 'FER-006', 'CHS-FER-1006', 'Ferrari', '488 GTB', 2024, 'Red', 'Available', 500.00),
(7, 'JEEP-007', 'CHS-JEEP-1007', 'Jeep', 'Wrangler', 2023, 'Black', 'Available', 190.00),
(8, 'HYU-008', 'CHS-HYU-1008', 'Hyundai', 'Sonata', 2023, 'Silver', 'Available', 110.00),
(9, 'KIA-009', 'CHS-KIA-1009', 'Kia', 'K8', 2024, 'White', 'Available', 130.00),
(10, 'MAZ-010', 'CHS-MAZ-1010', 'Mazda', 'RX7', 2022, 'Blue', 'Available', 240.00),
(11, 'LEX-011', 'CHS-LEX-1011', 'Lexus', 'LX600', 2024, 'Black', 'Available', 380.00),
(12, 'CHEV-012', 'CHS-CHEV-1012', 'Chevrolet', 'Tahoe', 2024, 'Black', 'Available', 260.00);

-- --------------------------------------------------------

--
-- بنية الجدول `cardelivery`
--

CREATE TABLE `cardelivery` (
  `CarDelivery_ID` int(11) NOT NULL,
  `Rental_ID` int(11) NOT NULL,
  `DeliveryDate` date NOT NULL,
  `Condition` varchar(50) NOT NULL,
  `Employee_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `carreturn`
--

CREATE TABLE `carreturn` (
  `CarReturn_ID` int(11) NOT NULL,
  `Rental_ID` int(11) NOT NULL,
  `ReturnDate` date NOT NULL,
  `Condition` varchar(50) NOT NULL,
  `Employee_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `customer`
--

CREATE TABLE `customer` (
  `Customer_ID` int(11) NOT NULL,
  `Person_ID` int(11) NOT NULL,
  `LicenseNumber` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `employee`
--

CREATE TABLE `employee` (
  `Employee_ID` int(11) NOT NULL,
  `Person_ID` int(11) NOT NULL,
  `Job` varchar(50) NOT NULL,
  `Salary` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `expense`
--

CREATE TABLE `expense` (
  `Expense_ID` int(11) NOT NULL,
  `Branch_ID` int(11) NOT NULL,
  `Cost` decimal(10,2) NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `maintenance`
--

CREATE TABLE `maintenance` (
  `Maintenance_ID` int(11) NOT NULL,
  `Car_ID` int(11) NOT NULL,
  `ServiceDate` date NOT NULL,
  `Description` varchar(255) NOT NULL,
  `Cost` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `payment`
--

CREATE TABLE `payment` (
  `Payment_ID` int(11) NOT NULL,
  `Rental_ID` int(11) NOT NULL,
  `Amount` decimal(10,2) NOT NULL,
  `PaymentDate` date NOT NULL,
  `PaymentType` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `person`
--

CREATE TABLE `person` (
  `Person_ID` int(11) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `Phone` varchar(20) NOT NULL,
  `Address` varchar(150) DEFAULT NULL,
  `National` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `rentalcontract`
--

CREATE TABLE `rentalcontract` (
  `Rental_ID` int(11) NOT NULL,
  `StartDate` date NOT NULL,
  `EndDate` date NOT NULL,
  `TotalAmount` decimal(10,2) NOT NULL,
  `Deposit` decimal(10,2) NOT NULL,
  `Discount` int(11) DEFAULT 0,
  `ContractStatus` varchar(30) NOT NULL,
  `Customer_ID` int(11) NOT NULL,
  `Car_ID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- بنية الجدول `user`
--

CREATE TABLE `user` (
  `User_ID` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Status` varchar(20) NOT NULL,
  `Role` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- إرجاع أو استيراد بيانات الجدول `user`
--

INSERT INTO `user` (`User_ID`, `Username`, `Password`, `Status`, `Role`) VALUES
(1, 'admin', '1234', 'ACTIVE', 'ADMIN');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `backuplog`
--
ALTER TABLE `backuplog`
  ADD PRIMARY KEY (`Backup_ID`),
  ADD KEY `User_ID` (`User_ID`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`Branch_ID`);

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD PRIMARY KEY (`Car_ID`),
  ADD UNIQUE KEY `PlateNumber` (`PlateNumber`),
  ADD UNIQUE KEY `ChassisNumber` (`ChassisNumber`);

--
-- Indexes for table `cardelivery`
--
ALTER TABLE `cardelivery`
  ADD PRIMARY KEY (`CarDelivery_ID`),
  ADD KEY `Rental_ID` (`Rental_ID`),
  ADD KEY `Employee_ID` (`Employee_ID`);

--
-- Indexes for table `carreturn`
--
ALTER TABLE `carreturn`
  ADD PRIMARY KEY (`CarReturn_ID`),
  ADD KEY `Rental_ID` (`Rental_ID`),
  ADD KEY `Employee_ID` (`Employee_ID`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_ID`),
  ADD UNIQUE KEY `LicenseNumber` (`LicenseNumber`),
  ADD KEY `Person_ID` (`Person_ID`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`Employee_ID`),
  ADD KEY `Person_ID` (`Person_ID`);

--
-- Indexes for table `expense`
--
ALTER TABLE `expense`
  ADD PRIMARY KEY (`Expense_ID`),
  ADD KEY `Branch_ID` (`Branch_ID`);

--
-- Indexes for table `maintenance`
--
ALTER TABLE `maintenance`
  ADD PRIMARY KEY (`Maintenance_ID`),
  ADD KEY `Car_ID` (`Car_ID`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`Payment_ID`),
  ADD KEY `Rental_ID` (`Rental_ID`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`Person_ID`);

--
-- Indexes for table `rentalcontract`
--
ALTER TABLE `rentalcontract`
  ADD PRIMARY KEY (`Rental_ID`),
  ADD KEY `Customer_ID` (`Customer_ID`),
  ADD KEY `Car_ID` (`Car_ID`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`User_ID`),
  ADD UNIQUE KEY `Username` (`Username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `backuplog`
--
ALTER TABLE `backuplog`
  MODIFY `Backup_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `Branch_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `car`
--
ALTER TABLE `car`
  MODIFY `Car_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `cardelivery`
--
ALTER TABLE `cardelivery`
  MODIFY `CarDelivery_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `carreturn`
--
ALTER TABLE `carreturn`
  MODIFY `CarReturn_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `Employee_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `expense`
--
ALTER TABLE `expense`
  MODIFY `Expense_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `maintenance`
--
ALTER TABLE `maintenance`
  MODIFY `Maintenance_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `Payment_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `person`
--
ALTER TABLE `person`
  MODIFY `Person_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `rentalcontract`
--
ALTER TABLE `rentalcontract`
  MODIFY `Rental_ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `User_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- قيود الجداول المُلقاة.
--

--
-- قيود الجداول `backuplog`
--
ALTER TABLE `backuplog`
  ADD CONSTRAINT `backuplog_ibfk_1` FOREIGN KEY (`User_ID`) REFERENCES `user` (`User_ID`);

--
-- قيود الجداول `cardelivery`
--
ALTER TABLE `cardelivery`
  ADD CONSTRAINT `cardelivery_ibfk_1` FOREIGN KEY (`Rental_ID`) REFERENCES `rentalcontract` (`Rental_ID`),
  ADD CONSTRAINT `cardelivery_ibfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`);

--
-- قيود الجداول `carreturn`
--
ALTER TABLE `carreturn`
  ADD CONSTRAINT `carreturn_ibfk_1` FOREIGN KEY (`Rental_ID`) REFERENCES `rentalcontract` (`Rental_ID`),
  ADD CONSTRAINT `carreturn_ibfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `employee` (`Employee_ID`);

--
-- قيود الجداول `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `customer_ibfk_1` FOREIGN KEY (`Person_ID`) REFERENCES `person` (`Person_ID`);

--
-- قيود الجداول `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`Person_ID`) REFERENCES `person` (`Person_ID`);

--
-- قيود الجداول `expense`
--
ALTER TABLE `expense`
  ADD CONSTRAINT `expense_ibfk_1` FOREIGN KEY (`Branch_ID`) REFERENCES `branch` (`Branch_ID`);

--
-- قيود الجداول `maintenance`
--
ALTER TABLE `maintenance`
  ADD CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`Car_ID`) REFERENCES `car` (`Car_ID`);

--
-- قيود الجداول `payment`
--
ALTER TABLE `payment`
  ADD CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`Rental_ID`) REFERENCES `rentalcontract` (`Rental_ID`);

--
-- قيود الجداول `rentalcontract`
--
ALTER TABLE `rentalcontract`
  ADD CONSTRAINT `rentalcontract_ibfk_1` FOREIGN KEY (`Customer_ID`) REFERENCES `customer` (`Customer_ID`),
  ADD CONSTRAINT `rentalcontract_ibfk_2` FOREIGN KEY (`Car_ID`) REFERENCES `car` (`Car_ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
