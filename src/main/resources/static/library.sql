/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-04-26 17:58:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `author` varchar(255) DEFAULT NULL,
  `publishing_date` datetime DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `lended` int(11) DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三体', '刘慈欣', null, null, null, null, '');
INSERT INTO `book` VALUES ('2', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, 'bbacd9ec-5144-426a-8ee1-c96d0033de51.jpg');
INSERT INTO `book` VALUES ('3', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('4', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('10', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('11', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('12', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('13', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('17', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('18', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('19', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('20', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('21', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('22', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('23', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('24', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('32', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('33', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('34', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('35', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('36', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('37', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('38', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('39', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('40', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('41', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('42', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('43', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('44', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('45', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('46', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('47', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('63', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('64', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('65', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('66', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('67', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('68', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('69', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('70', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('71', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('72', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('73', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('74', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('75', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('76', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('77', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('78', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('79', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('80', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('81', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('82', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('83', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('84', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('85', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('86', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('87', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('88', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('89', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('90', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('91', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('92', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('93', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('94', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('126', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('127', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('128', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('129', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('130', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('131', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('132', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('133', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('134', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('135', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('136', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('137', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('138', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('139', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('140', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('141', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('142', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('143', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('144', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('145', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('146', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('147', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('148', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('149', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('150', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('151', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('152', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('153', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('154', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('155', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('156', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('157', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('158', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('159', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('160', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('161', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('162', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('163', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('164', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('165', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('166', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('167', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('168', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('169', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('170', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('171', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('172', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('173', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('174', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('175', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('176', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('177', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('178', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('179', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('180', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('181', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('182', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('183', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('184', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('185', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('186', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('187', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);
INSERT INTO `book` VALUES ('188', '三只小猪', 'ww', null, null, null, null, null);
INSERT INTO `book` VALUES ('189', '三体', '刘慈欣', null, null, null, null, null);

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', 'ww', '123456', '1');

-- ----------------------------
-- Table structure for single_book
-- ----------------------------
DROP TABLE IF EXISTS `single_book`;
CREATE TABLE `single_book` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `scheduled_return_time` datetime DEFAULT NULL,
  `borrow_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of single_book
-- ----------------------------
