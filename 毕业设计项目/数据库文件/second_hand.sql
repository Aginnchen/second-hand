/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : second_hand

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2019-12-24 18:43:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_administrator
-- ----------------------------
DROP TABLE IF EXISTS `t_administrator`;
CREATE TABLE `t_administrator` (
  `user_account` varchar(11) DEFAULT NULL,
  `user_name` varchar(11) DEFAULT NULL,
  `user_password` varchar(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `sex` varchar(11) DEFAULT NULL,
  `registration_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_administrator
-- ----------------------------
INSERT INTO `t_administrator` VALUES ('17674703681', '陈帅', '111111', '17674703681', '1', '男', '2019-12-09 21:50:53');

-- ----------------------------
-- Table structure for t_car
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `brand_id` int(200) NOT NULL AUTO_INCREMENT,
  `brand` varchar(200) DEFAULT NULL,
  `money` varchar(500) DEFAULT NULL,
  `model` varchar(500) DEFAULT NULL,
  `color` varchar(500) DEFAULT NULL,
  `state` varchar(500) DEFAULT NULL,
  `configuration` varchar(500) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `market_time` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`brand_id`),
  KEY `fk_ad_car` (`user_id`),
  CONSTRAINT `fk_ad_car` FOREIGN KEY (`user_id`) REFERENCES `t_administrator` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '大众 ', '14.71万', '大众 途观 2015款 1.8TSI 自动两驱舒适版', '黑色', '德国', '发动机：1.8T/160马力/L4', '1', '1', '2019-12-13');
INSERT INTO `t_car` VALUES ('2', '奔驰', '23.93万', '奔驰A级 2019款 A 200 动感型(进口)', '黑色', '德国', '发动机：1.3T/163马力/L4', '0', '1', '2019-12-13');
INSERT INTO `t_car` VALUES ('3', '奥迪', '17.90万', '奥迪A4L 2015款 35 TFSI 自动舒适型', '黑色', '德国', '发动机：2.0T/180马力/L4', '0', '1', '2019-12-13');
INSERT INTO `t_car` VALUES ('4', '测试数据', '221', '1221', '2112', '22121', '囖咯', '0', '1', '2019-12-13');
INSERT INTO `t_car` VALUES ('5', '奥迪', '180王', '吴大兴', '22', '德国', 'sdss', '0', '1', '2019-12-13');
INSERT INTO `t_car` VALUES ('6', '5', '33', '22', 'ee', 'ee', '22', '1', null, null);
INSERT INTO `t_car` VALUES ('7', '大众', '11', '11', '11', '11', '11', '0', null, null);
INSERT INTO `t_car` VALUES ('8', '231', '421', '23', '124', '214', '1241', '0', null, null);
INSERT INTO `t_car` VALUES ('9', '李娜傻逼', '李娜傻逼', '李娜傻逼', '李娜傻逼', '李娜傻逼', '李娜傻逼', '0', null, null);
INSERT INTO `t_car` VALUES ('10', '智障', '智障', '智障', '智障', '智障', '智障', '0', null, null);
INSERT INTO `t_car` VALUES ('11', '宝马', 'n牛逼', 'weweq', 'n牛逼', 'n牛逼', 'n牛逼', '0', null, '2019-12-16');
INSERT INTO `t_car` VALUES ('12', '嘎嘎嘎然而', '30000', '嘎嘎嘎然而', '红色', '美国', '嘎嘎嘎然而', '0', null, null);

-- ----------------------------
-- Table structure for t_orded
-- ----------------------------
DROP TABLE IF EXISTS `t_orded`;
CREATE TABLE `t_orded` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `quantity` varchar(500) DEFAULT NULL,
  `user_name` varchar(30) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `money` varchar(200) DEFAULT NULL,
  `brand` varchar(200) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT NULL,
  `order_time` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  KEY `fk_ad_orded` (`user_id`),
  CONSTRAINT `fk_ad_orded` FOREIGN KEY (`user_id`) REFERENCES `t_administrator` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orded
-- ----------------------------
INSERT INTO `t_orded` VALUES ('1', 'qq', 'qq', '1', 'qq', 'aa', '0', 'aa');
INSERT INTO `t_orded` VALUES ('2', 'qq', 'gb', '1', 'aa', '大众', '0', '2019-12-12');
INSERT INTO `t_orded` VALUES ('3', '21', 'gb', '1', '23', '大众', '0', '2019-12-12');
INSERT INTO `t_orded` VALUES ('4', '奥迪', '奥迪', null, '奥迪', '奥迪', '0', '奥迪');
INSERT INTO `t_orded` VALUES ('5', 'dda', '陈帅', null, 'aa', 'qq', '0', '2019-12-16');
INSERT INTO `t_orded` VALUES ('6', '宝马', '智障', null, '2000万', '4', '0', '2019-12-16');
INSERT INTO `t_orded` VALUES ('7', '300wang==', '300wang==', null, '300wang==', null, '1', '20201-11-22');
INSERT INTO `t_orded` VALUES ('8', null, null, null, null, null, '1', null);
INSERT INTO `t_orded` VALUES ('9', null, '陈帅', null, '30万', null, '1', '2012-12-15');
INSERT INTO `t_orded` VALUES ('10', null, '陈帅', null, '30万', '大众', '1', '2016-16-22');
INSERT INTO `t_orded` VALUES ('11', null, '啦啦啦', null, '3000万', '大众', '0', '2019-12-20');
INSERT INTO `t_orded` VALUES ('12', null, '331', null, '222', '大众', '0', '2321321');
INSERT INTO `t_orded` VALUES ('13', null, '331', null, '222', '大众', '0', '2321321');
INSERT INTO `t_orded` VALUES ('14', null, '331', null, '222', '大众', '0', '2321321');
INSERT INTO `t_orded` VALUES ('15', null, '331', null, '222', '大众', '0', '2321321');
INSERT INTO `t_orded` VALUES ('16', null, '衬衫', null, '300', '宝马', '0', '2019-12-20');

-- ----------------------------
-- Table structure for t_shopping
-- ----------------------------
DROP TABLE IF EXISTS `t_shopping`;
CREATE TABLE `t_shopping` (
  `brand_id` varchar(20) DEFAULT NULL,
  `quantity` varchar(500) DEFAULT NULL,
  `configuration` varchar(500) DEFAULT NULL,
  `money` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_shopping
-- ----------------------------
INSERT INTO `t_shopping` VALUES ('品牌', '详情', '配置', '价格');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(32) DEFAULT NULL,
  `user_name` varchar(11) DEFAULT NULL,
  `user_password` varchar(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `sex` varchar(11) DEFAULT NULL,
  `is_deleted` int(1) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('29', '17777777777', '您好', '123456', '17777777777', '1', '0', '2019-12-12');
INSERT INTO `t_user` VALUES ('30', '', '', '', '', '', '0', '2019-12-12');
INSERT INTO `t_user` VALUES ('31', '23337463455', '陈帅', '111111', '17666666666', '0', '0', null);
INSERT INTO `t_user` VALUES ('32', '17666666666', '陈陈', '111111', '17666666666', '1', '0', null);
INSERT INTO `t_user` VALUES ('33', '23337463455', '智障', '111111', '18888888888', '1', '0', null);
INSERT INTO `t_user` VALUES ('34', '11111111111', 'cc', '111111', '17777777777', '1', '0', null);
INSERT INTO `t_user` VALUES ('35', '1111', '221', '111111', '2222', '2222', null, '');
INSERT INTO `t_user` VALUES ('36', '13455555555', '13455555555', '111111', '13455555555', '女', '0', '2019-12-23');
INSERT INTO `t_user` VALUES ('37', '15323345698', '胡智障1', '123456', '15323345698', '男', '0', '2019-12-22');
INSERT INTO `t_user` VALUES ('42', '13455555555', '陈陈', '111111', '13455555555', '男', null, '');
INSERT INTO `t_user` VALUES ('43', '18888888888', '11', '123456', '18888888888', '1', null, '');
INSERT INTO `t_user` VALUES ('45', '16666666666', 'qq', '123456', '16666666666', '1', '0', '');
INSERT INTO `t_user` VALUES ('46', '13668998595', '陈帅', '123456', '13668998595', '0', '0', '');
