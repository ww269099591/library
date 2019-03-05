/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 80011
Source Host           : localhost:3306
Source Database       : library

Target Server Type    : MYSQL
Target Server Version : 80011
File Encoding         : 65001

Date: 2019-03-05 17:57:02
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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '三体', '刘慈欣', null, null, null, null, null);
INSERT INTO `book` VALUES ('2', '权力的游戏', '乔治.r.r.马丁', null, null, null, null, null);

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
