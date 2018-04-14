/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : portal_new

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-04-12 19:57:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `role_id` varchar(32) DEFAULT NULL,
  `authority_id` varchar(32) DEFAULT NULL,
  KEY `FK_Reference_4` (`role_id`),
  KEY `FK_Reference_5` (`authority_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';

-- ----------------------------
-- Records of role_authority
-- ----------------------------

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `authority_id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `type` varchar(1) DEFAULT NULL,
  `authority_name` varchar(50) DEFAULT NULL,
  `authority_desc` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `classes` varchar(255) DEFAULT NULL,
  `item_id` varchar(32) DEFAULT NULL,
  `able` varchar(1) DEFAULT NULL,
  `icon` varchar(32) DEFAULT NULL,
  `sort_num` int(20) DEFAULT NULL,
  `create_time` bigint(15) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of sys_authority
-- ----------------------------

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `department_id` varchar(32) NOT NULL,
  `parent_id` varchar(32) DEFAULT NULL,
  `department_name` varchar(32) DEFAULT NULL,
  `department_code` varchar(32) DEFAULT NULL,
  `description` varchar(32) DEFAULT NULL,
  `sortcode` varchar(11) DEFAULT NULL,
  `able` int(1) DEFAULT NULL,
  `create_time` bigint(15) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门表';

-- ----------------------------
-- Records of sys_department
-- ----------------------------

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` varchar(32) NOT NULL,
  `role_name` varchar(100) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(32) NOT NULL,
  `department_id` varchar(32) DEFAULT NULL,
  `user_name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `id_card` varchar(18) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `telephone` varchar(15) DEFAULT NULL,
  `able` varchar(1) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `create_user_id` varchar(32) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` varchar(32) DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_1` (`department_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`department_id`) REFERENCES `sys_department` (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` varchar(32) DEFAULT NULL,
  `role_id` varchar(32) DEFAULT NULL,
  KEY `FK_Reference_2` (`user_id`),
  KEY `FK_Reference_3` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
