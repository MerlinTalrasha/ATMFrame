/*
Navicat MySQL Data Transfer

Source Server         : Merlin
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-12 12:32:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `atm`
-- ----------------------------
DROP TABLE IF EXISTS `atm`;
CREATE TABLE `atm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `personid` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ceiling` int(11) DEFAULT NULL,
  `balance` int(11) DEFAULT NULL,
  `accounttype` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1052 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of atm
-- ----------------------------
INSERT INTO `atm` VALUES ('1000', 'test', '123', '123', '123', '400', '213', '1');
INSERT INTO `atm` VALUES ('1001', 'test5', '123', '123', '123', '0', '394', '0');
INSERT INTO `atm` VALUES ('1007', 'test3', '123', '123', '123', '123', '23', '1');
INSERT INTO `atm` VALUES ('1015', 'test1', '123', '123', '123', '111', '111', '1');
INSERT INTO `atm` VALUES ('1019', 'test6', '123', '123', '123', '123', '823', '1');
INSERT INTO `atm` VALUES ('1020', 'test7', '123', '123', '123', '123', '123', '1');
INSERT INTO `atm` VALUES ('1021', 'test8', '123', '123', '123', '0', '123', '0');
INSERT INTO `atm` VALUES ('1022', 'test9', '123', '123', '123', '0', '123', '0');
INSERT INTO `atm` VALUES ('1023', 'test1', '123', '123', '123', '0', '123', '0');
INSERT INTO `atm` VALUES ('1035', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1036', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1037', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1038', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1040', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1042', 'test11', '123', '123', '123', '0', '0', '0');
INSERT INTO `atm` VALUES ('1043', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1044', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1045', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1047', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1048', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1049', 'test11', '123', '123', '123', '0', '0', '1');
INSERT INTO `atm` VALUES ('1050', 'test11', '123', '123', '123', '0', '0', '0');
