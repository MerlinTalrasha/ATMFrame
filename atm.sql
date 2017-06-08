/*
Navicat MySQL Data Transfer

Source Server         : Merlin
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-08 10:55:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `atm`
-- ----------------------------
DROP TABLE IF EXISTS `atm`;
CREATE TABLE `atm` (
  `id` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `personid` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ceiling` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `accounttype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of atm
-- ----------------------------
INSERT INTO `atm` VALUES ('1', 'test', '123', '123', '123', '111', '111', '1');
INSERT INTO `atm` VALUES ('2', 'test2', '123', '123', '123', '111', '111', '1');
INSERT INTO `atm` VALUES ('3', 'test3', '123', '123', '123', '111', '111', '0');
INSERT INTO `atm` VALUES ('4', 'test4', '123', '123', '123', '111', '111', '1');
