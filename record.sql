/*
Navicat MySQL Data Transfer

Source Server         : Merlin
Source Server Version : 50718
Source Host           : localhost:3306
Source Database       : mysql

Target Server Type    : MYSQL
Target Server Version : 50718
File Encoding         : 65001

Date: 2017-06-12 12:32:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `card` int(11) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `operate` varchar(255) DEFAULT NULL,
  `money` int(11) DEFAULT NULL,
  `username2` varchar(255) DEFAULT NULL,
  `card2` int(11) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('1', '1000', 'test', '存款', '100', null, null, '2017年06月11日 22:41:48');
INSERT INTO `record` VALUES ('2', '1000', 'test', '取款', '100', null, null, '2017年06月11日 22:49:45');
INSERT INTO `record` VALUES ('3', '1000', 'test', '取款', '100', null, null, '2017年06月11日 22:50:16');
INSERT INTO `record` VALUES ('4', '1000', 'test', '存款', '100', null, null, '2017年06月11日 22:50:19');
INSERT INTO `record` VALUES ('5', '1000', 'test', '转账', '1000', 'test5', '1001', '2017年06月11日 23:03:30');
INSERT INTO `record` VALUES ('6', '1000', 'test', '转账', '1000', 'test5', '1001', '2017年06月11日 23:06:14');
INSERT INTO `record` VALUES ('7', '1000', 'test', '转账', '100', 'test5', '1001', '2017年06月11日 23:09:56');
INSERT INTO `record` VALUES ('8', '1000', 'test', '存款', '100', null, null, '2017年06月11日 23:11:24');
INSERT INTO `record` VALUES ('9', '1000', 'test', '取款', '100', null, null, '2017年06月11日 23:11:33');
INSERT INTO `record` VALUES ('10', '1000', 'test', '转账', '100', 'test5', '1001', '2017年06月11日 23:12:15');
INSERT INTO `record` VALUES ('11', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:35:57');
INSERT INTO `record` VALUES ('12', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:05');
INSERT INTO `record` VALUES ('13', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:08');
INSERT INTO `record` VALUES ('14', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:10');
INSERT INTO `record` VALUES ('15', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:12');
INSERT INTO `record` VALUES ('16', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:14');
INSERT INTO `record` VALUES ('17', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:16');
INSERT INTO `record` VALUES ('18', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:18');
INSERT INTO `record` VALUES ('19', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:20');
INSERT INTO `record` VALUES ('20', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:21');
INSERT INTO `record` VALUES ('21', '1019', 'test6', '存款', '100', null, null, '2017年06月11日 23:36:36');
INSERT INTO `record` VALUES ('22', '1019', 'test6', '取款', '100', null, null, '2017年06月11日 23:37:21');
INSERT INTO `record` VALUES ('23', '1019', 'test6', '取款', '100', null, null, '2017年06月11日 23:37:23');
INSERT INTO `record` VALUES ('24', '1019', 'test6', '取款', '100', null, null, '2017年06月11日 23:37:25');
INSERT INTO `record` VALUES ('25', '1019', 'test6', '取款', '100', null, null, '2017年06月11日 23:37:27');
INSERT INTO `record` VALUES ('26', '1007', 'test3', '取款', '100', null, null, '2017年06月11日 23:38:58');
INSERT INTO `record` VALUES ('27', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:49:14');
INSERT INTO `record` VALUES ('28', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:49:25');
INSERT INTO `record` VALUES ('29', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:49:34');
INSERT INTO `record` VALUES ('30', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:49:44');
INSERT INTO `record` VALUES ('31', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:49:57');
INSERT INTO `record` VALUES ('32', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:50:06');
INSERT INTO `record` VALUES ('33', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:50:33');
INSERT INTO `record` VALUES ('34', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:50:41');
INSERT INTO `record` VALUES ('35', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:50:48');
INSERT INTO `record` VALUES ('36', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:50:55');
INSERT INTO `record` VALUES ('37', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:51:02');
INSERT INTO `record` VALUES ('38', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:51:11');
INSERT INTO `record` VALUES ('39', '1000', 'test', '转账', '1', 'test', '1000', '2017年06月11日 23:51:29');
INSERT INTO `record` VALUES ('40', '1001', 'test5', '转账', '1', 'test', '1000', '2017年06月11日 23:52:54');
INSERT INTO `record` VALUES ('41', '1000', 'test', '存款', '100', null, null, '2017年06月12日 10:45:47');
INSERT INTO `record` VALUES ('42', '1000', 'test', '取款', '100', null, null, '2017年06月12日 10:46:20');
INSERT INTO `record` VALUES ('43', '1000', 'test', '转账', '100', 'test5', '1001', '2017年06月12日 10:46:35');
INSERT INTO `record` VALUES ('44', '1000', 'test', '转账', '1', 'test5', '1001', '2017年06月12日 10:53:26');
