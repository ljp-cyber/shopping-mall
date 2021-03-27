/*
MySQL Backup
Source Server Version: 8.0.16
Source Database: shops
Date: 2021/3/27 21:40:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
--  Table structure for `brand`
-- ----------------------------
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL COMMENT '品牌id',
  `name` varchar(20) NOT NULL COMMENT '品牌名称',
  `represent` varchar(200) DEFAULT NULL COMMENT '类别描述',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(20) NOT NULL COMMENT '类别id',
  `name` varchar(20) NOT NULL COMMENT '类别名称',
  `represent` varchar(200) DEFAULT NULL COMMENT '类别描述',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '图标',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `other_login`
-- ----------------------------
DROP TABLE IF EXISTS `other_login`;
CREATE TABLE `other_login` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `user_id` bigint(20) NOT NULL COMMENT '用户id，外建',
  `other_id` bigint(20) NOT NULL COMMENT '第三方账号',
  `other_app` varchar(20) NOT NULL COMMENT '第三方app',
  `other_name` varchar(20) NOT NULL COMMENT '第三方昵称',
  `other_sex` char(1) NOT NULL COMMENT '第三方性别',
  `other_adress` varchar(20) NOT NULL COMMENT '第三方地区',
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `other_login_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(50) NOT NULL COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '用户名',
  `nick_name` varchar(20) NOT NULL COMMENT '昵称',
  `icon` varchar(100) NOT NULL DEFAULT '' COMMENT '头像名称',
  `birthday` datetime NOT NULL,
  `password` varchar(100) NOT NULL COMMENT '密码',
  `sex` char(1) NOT NULL COMMENT '性别',
  `phone` char(20) NOT NULL COMMENT '电话',
  `email` varchar(30) NOT NULL DEFAULT '' COMMENT '邮箱',
  `role` varchar(10) NOT NULL DEFAULT 'normal' COMMENT '角色：normal,vip,tourist,admin,black',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_safe`
-- ----------------------------
DROP TABLE IF EXISTS `user_safe`;
CREATE TABLE `user_safe` (
  `user_id` bigint(20) NOT NULL COMMENT '用户id',
  `last_login_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后登录时间',
  `last_login_ip` char(40) NOT NULL DEFAULT '' COMMENT '最后登录IP',
  `last_login_mac` char(17) NOT NULL DEFAULT '' COMMENT '最后登录mac地址',
  `last_login_source` char(3) NOT NULL DEFAULT 'UNK' COMMENT '最后登录方式：WEB,IOS,AND,ADM,UNK',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后更新时间',
  `register_data` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `register_source` char(3) NOT NULL DEFAULT 'UNK' COMMENT '注册方式：WEB,IOS,AND,ADM,UNK,',
  `register_adress` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`user_id`),
  CONSTRAINT `user_safe_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records 
-- ----------------------------
INSERT INTO `brand` VALUES ('1','拉克丝','品牌女装','null');
INSERT INTO `category` VALUES ('1','手机','潮流商品','http://shxex.cn/images/g1.png'), ('1373593584476880896','张飞','haha','null');
INSERT INTO `user` VALUES ('1271710721972895744','haha','haha','123123','2020-06-02 00:00:00','$2a$10$5rN/lmMwgGyG7yObT9pdXudos2HHDmtrS5LPOWdKYAxumwPcDZk.6','男','17876383933','haha@qq.com','admin');
INSERT INTO `user_safe` VALUES ('1271710721972895744','2021-03-27 15:37:31','0:0:0:0:0:0:0:1','','WEB','2020-06-17 11:51:53','2020-06-17 11:51:53','WEB','0|0|0|内网IP|内网IP');

SET FOREIGN_KEY_CHECKS=1;
