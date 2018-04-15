/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : portal_new

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2018-04-15 18:30:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role_authority
-- ----------------------------
DROP TABLE IF EXISTS `role_authority`;
CREATE TABLE `role_authority` (
  `role_id` int(11) DEFAULT NULL COMMENT '������ɫid',
  `authority_id` int(11) DEFAULT NULL COMMENT '����Ȩ��id',
  KEY `FK_Reference_4` (`role_id`),
  KEY `FK_Reference_5` (`authority_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`authority_id`) REFERENCES `sys_authority` (`authority_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='��ɫȨ�޹�����';

-- ----------------------------
-- Records of role_authority
-- ----------------------------
INSERT INTO `role_authority` VALUES ('1', '1');
INSERT INTO `role_authority` VALUES ('2', '2');
INSERT INTO `role_authority` VALUES ('1', '2');

-- ----------------------------
-- Table structure for sys_authority
-- ----------------------------
DROP TABLE IF EXISTS `sys_authority`;
CREATE TABLE `sys_authority` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '��id',
  `type` varchar(1) DEFAULT NULL COMMENT '���ͣ�1ϵͳ��2�˵���3��ť��',
  `authority_name` varchar(50) DEFAULT NULL COMMENT 'Ȩ������',
  `authority_desc` varchar(255) DEFAULT NULL COMMENT 'Ȩ������',
  `url` varchar(255) DEFAULT NULL COMMENT '��ַ',
  `classes` varchar(255) DEFAULT NULL COMMENT '��ʽ',
  `item_id` varchar(32) DEFAULT NULL COMMENT '���id',
  `able` varchar(1) DEFAULT NULL COMMENT '1���ã�0ͣ��',
  `icon` varchar(32) DEFAULT NULL COMMENT 'ͼ��',
  `sort_num` int(2) DEFAULT NULL COMMENT '�����',
  `create_time` bigint(15) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '1������0�߼�ɾ��',
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='Ȩ�ޣ�ϵͳ���˵�����ť��';

-- ----------------------------
-- Records of sys_authority
-- ----------------------------
INSERT INTO `sys_authority` VALUES ('1', null, '1', '权限1', null, null, null, 'portal', null, null, null, null, null, null, null, '1');
INSERT INTO `sys_authority` VALUES ('2', '1', null, '权限2', null, null, null, 'mips', null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for sys_department
-- ----------------------------
DROP TABLE IF EXISTS `sys_department`;
CREATE TABLE `sys_department` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `parent_id` int(11) DEFAULT NULL COMMENT '������id',
  `department_name` varchar(32) DEFAULT NULL COMMENT '��������',
  `department_code` varchar(32) DEFAULT NULL COMMENT '���ű���',
  `description` varchar(32) DEFAULT NULL COMMENT '��������',
  `sortcode` int(11) DEFAULT NULL COMMENT '�����',
  `able` varchar(1) DEFAULT NULL COMMENT '1���ã�0ͣ��',
  `create_time` bigint(15) DEFAULT NULL COMMENT '����ʱ��',
  `create_user_id` int(11) DEFAULT NULL COMMENT '���������û�id',
  `update_time` bigint(20) DEFAULT NULL COMMENT '����ʱ��',
  `update_user_id` int(11) DEFAULT NULL COMMENT '�����û�id',
  `status` varchar(1) DEFAULT NULL COMMENT '1������0�߼�ɾ��',
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='����';

-- ----------------------------
-- Records of sys_department
-- ----------------------------
INSERT INTO `sys_department` VALUES ('1', null, '部门1', null, null, null, null, null, null, null, null, '1');
INSERT INTO `sys_department` VALUES ('2', '1', '部门2', null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(100) DEFAULT NULL COMMENT '��ɫ����',
  `role_desc` varchar(255) DEFAULT NULL COMMENT '��ɫ����',
  `create_time` bigint(20) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '1������0�߼�ɾ��',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='��ɫ';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '角色1', null, null, null, null, null, '1');
INSERT INTO `sys_role` VALUES ('2', '角色2', null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_id` varchar(50) DEFAULT NULL COMMENT '��������id(������Ÿ��)',
  `user_name` varchar(32) DEFAULT NULL COMMENT '�û���',
  `password` varchar(32) DEFAULT NULL COMMENT '����',
  `real_name` varchar(32) DEFAULT NULL COMMENT '��ʵ����',
  `sex` varchar(1) DEFAULT NULL COMMENT '�Ա�1�У�0Ů��',
  `post` varchar(32) DEFAULT NULL COMMENT '��λ',
  `nation` varchar(20) DEFAULT NULL COMMENT '����',
  `id_card` varchar(18) DEFAULT NULL COMMENT '���֤',
  `email` varchar(50) DEFAULT NULL COMMENT '����',
  `telephone` varchar(15) DEFAULT NULL COMMENT '�绰',
  `able` varchar(1) DEFAULT NULL COMMENT '1���ã�0ͣ��',
  `create_time` bigint(20) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `update_user_id` int(11) DEFAULT NULL,
  `status` varchar(1) DEFAULT NULL COMMENT '1������0�߼�ɾ��',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='�û�';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '1,2', 'admin', '123456', '用户1', '1', null, null, null, null, null, null, null, null, null, null, '1');
INSERT INTO `sys_user` VALUES ('2', '2', 'u2', 'p2', '用户2', '0', null, null, null, null, null, null, null, null, null, null, '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` int(11) DEFAULT NULL COMMENT '�����û�id',
  `role_id` int(11) DEFAULT NULL COMMENT '������ɫid',
  KEY `FK_Reference_2` (`user_id`),
  KEY `FK_Reference_3` (`role_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`user_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='�û���ɫ������';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1');
