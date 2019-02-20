/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-02-20 22:39:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for advice
-- ----------------------------
DROP TABLE IF EXISTS `advice`;
CREATE TABLE `advice` (
  `a_id` varchar(50) NOT NULL,
  `a_userid` varchar(50) NOT NULL,
  `a_message` varchar(5000) NOT NULL,
  `a_isRead` int(1) DEFAULT NULL,
  `a_creattime` date DEFAULT NULL,
  PRIMARY KEY (`a_id`),
  KEY `wj` (`a_userid`),
  CONSTRAINT `wj` FOREIGN KEY (`a_userid`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of advice
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `c_id` varchar(50) NOT NULL,
  `c_fid` varchar(50) DEFAULT NULL,
  `c_newsid` varchar(50) DEFAULT NULL,
  `c_tinynewsid` varchar(50) NOT NULL,
  `c_creattime` date NOT NULL,
  `c_updatetime` date DEFAULT NULL,
  `c_message` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`c_id`),
  KEY `wj4` (`c_newsid`),
  KEY `c_tinynewsid` (`c_tinynewsid`),
  CONSTRAINT `wj4` FOREIGN KEY (`c_newsid`) REFERENCES `news` (`n_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `m_id` varchar(50) NOT NULL,
  `m_userid` varchar(50) DEFAULT NULL,
  `m_fid` varchar(50) DEFAULT NULL,
  `m_name` varchar(50) NOT NULL,
  `m_creattime` date DEFAULT NULL,
  `m_updatetime` date DEFAULT NULL,
  PRIMARY KEY (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '1', null, '推荐', '2019-02-17', null);
INSERT INTO `menu` VALUES ('2', '1', null, '热点', null, null);
INSERT INTO `menu` VALUES ('3', '1', null, '科技', null, null);
INSERT INTO `menu` VALUES ('4', '1', null, '社会', null, null);
INSERT INTO `menu` VALUES ('5', '1', null, '体育', null, null);
INSERT INTO `menu` VALUES ('6', '1', null, '娱乐', null, null);
INSERT INTO `menu` VALUES ('7', '1', null, '游戏', null, null);

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `n_id` varchar(50) NOT NULL,
  `n_menuid` varchar(50) NOT NULL,
  `n_userid` varchar(255) NOT NULL,
  `n_title` varchar(255) NOT NULL,
  `n_cover` varchar(255) NOT NULL,
  `n_message` varchar(5000) NOT NULL,
  `n_creattime` date NOT NULL,
  `n_updatetime` date DEFAULT NULL,
  `n_commentnum` int(11) DEFAULT NULL,
  `n_browsenum` int(11) DEFAULT NULL,
  PRIMARY KEY (`n_id`),
  KEY `n_menuid` (`n_menuid`),
  KEY `wj5` (`n_userid`),
  CONSTRAINT `wj5` FOREIGN KEY (`n_userid`) REFERENCES `users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES ('1', '3', '3', '游戏标题1', '1', '这是新闻内容', '2019-02-17', null, null, null);
INSERT INTO `news` VALUES ('2', '3', '3', '游戏标题2', '2', '这是新闻内容', '2019-02-17', null, null, null);

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('1', 'mzb', '112233');
INSERT INTO `test` VALUES ('2', 'xxm', '001122');
INSERT INTO `test` VALUES ('3', 'ccx', '332211');
INSERT INTO `test` VALUES ('4', 'hentk', '5595555');

-- ----------------------------
-- Table structure for tinynews
-- ----------------------------
DROP TABLE IF EXISTS `tinynews`;
CREATE TABLE `tinynews` (
  `t_id` varchar(50) NOT NULL,
  `t_userid` varchar(50) NOT NULL,
  `t_message` varchar(5000) NOT NULL,
  `t_readnum` varchar(50) DEFAULT NULL,
  `t_likenum` varchar(10000) DEFAULT NULL,
  `t_image` varchar(255) DEFAULT NULL,
  `t_creattime` date NOT NULL,
  PRIMARY KEY (`t_id`),
  KEY `t_userid` (`t_userid`),
  CONSTRAINT `wj6` FOREIGN KEY (`t_id`) REFERENCES `comment` (`c_tinynewsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tinynews
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `u_id` varchar(255) NOT NULL,
  `u_name` varchar(255) DEFAULT NULL,
  `u_phone` varchar(255) NOT NULL,
  `u_mail` varchar(255) DEFAULT NULL,
  `u_password` varchar(255) NOT NULL,
  `u_type` varchar(255) DEFAULT NULL,
  `u_image` varchar(255) DEFAULT NULL,
  `u_province` varchar(255) DEFAULT NULL,
  `u_area` varchar(255) DEFAULT NULL,
  `u_town` varchar(255) DEFAULT NULL,
  `u_intro` varchar(255) DEFAULT NULL,
  `u_updatetime` date DEFAULT NULL,
  `u_creattime` date DEFAULT NULL,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'mzb', '17876253511', null, '123456', '管理员', null, null, null, null, null, null, null);
INSERT INTO `users` VALUES ('2', 'xmt', '15302207492', null, '123456', '普通用户', null, null, null, null, null, null, null);
INSERT INTO `users` VALUES ('3', 'bewhy', '10000000', null, '123456', '发文用户', null, null, null, null, null, null, null);
