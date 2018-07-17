/*
 Navicat MySQL Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : basic

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 07/17/2018 08:26:46 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `data`
-- ----------------------------
DROP TABLE IF EXISTS `data`;
CREATE TABLE `data` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `operateid` varchar(32) DEFAULT NULL COMMENT '操作主键',
  `rule` varchar(1024) DEFAULT NULL COMMENT '限定规则JSON串',
  `field` varchar(1024) DEFAULT NULL COMMENT '字段权限',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='数据表';

-- ----------------------------
--  Table structure for `element`
-- ----------------------------
DROP TABLE IF EXISTS `element`;
CREATE TABLE `element` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `code` varchar(32) DEFAULT NULL COMMENT '页面元素编码',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='页面元素表';

-- ----------------------------
--  Table structure for `file`
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `connectid` varchar(32) DEFAULT NULL COMMENT '关联主键',
  `name` varchar(128) DEFAULT NULL COMMENT '文件名',
  `path` varchar(254) DEFAULT NULL COMMENT '文件路径',
  `status` tinyint(4) NOT NULL DEFAULT '1' COMMENT '菜单状态：2：删除， 1：有效',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文件表';

-- ----------------------------
--  Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(16) DEFAULT NULL COMMENT '菜单名称',
  `icon` varchar(32) DEFAULT NULL COMMENT '菜单图标',
  `url` varchar(128) DEFAULT NULL COMMENT '菜单链接',
  `order` tinyint(4) NOT NULL COMMENT '序号',
  `parentid` varchar(32) DEFAULT NULL COMMENT '父级菜单主键',
  `status` tinyint(4) DEFAULT '1' COMMENT '菜单状态：2：删除， 1：启用， 0：禁用',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单表';

-- ----------------------------
--  Table structure for `operate`
-- ----------------------------
DROP TABLE IF EXISTS `operate`;
CREATE TABLE `operate` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(16) DEFAULT NULL COMMENT '操作名称',
  `url` varchar(128) DEFAULT NULL COMMENT '操作URL',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='功能操作表';

-- ----------------------------
--  Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `type` enum('MENU','OPERATE','ELEMENT','FILE') DEFAULT NULL COMMENT '权限类型',
  `connectid` varchar(32) DEFAULT NULL COMMENT '关联主键: 菜单表/页面元素表/文件表/功能操作表',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
--  Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `name` varchar(16) DEFAULT NULL COMMENT '角色名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
--  Records of `role`
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES ('123', '管理员');
COMMIT;

-- ----------------------------
--  Table structure for `rolepermission`
-- ----------------------------
DROP TABLE IF EXISTS `rolepermission`;
CREATE TABLE `rolepermission` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `roleid` varchar(32) DEFAULT NULL COMMENT '角色主键',
  `permissionid` varchar(32) DEFAULT NULL COMMENT '权限主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色关联权限表';

-- ----------------------------
--  Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `userid` varchar(16) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(64) DEFAULT NULL COMMENT '用户密码',
  `username` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `gender` tinyint(4) DEFAULT NULL COMMENT '性别：0:女，1：男，2:中性',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `mobilephone` varchar(16) DEFAULT NULL COMMENT '移动电话',
  `telephone` varchar(16) DEFAULT NULL COMMENT '座机号码',
  `job` varchar(32) DEFAULT NULL COMMENT '职位',
  `groupid` varchar(32) DEFAULT NULL COMMENT '所属组',
  `type` tinyint(4) DEFAULT '1' COMMENT '账户类型：1：普通用户，2：VIP用户，3：超级管理员',
  `status` tinyint(4) DEFAULT NULL COMMENT '账户状态0：禁用，1：启用， 2：邮箱未验证，3：手机号未验证',
  `lastlogindate` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `createdate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatedate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userid` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
--  Records of `user`
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('12', 'wupanhua', '123456', '吴盼华', '1', '2547182011@qqcom', '18201237239', '5301456', '开发', '1023', '1', '1', '2018-07-16 21:10:59', '2018-07-03 15:23:06', '2018-07-16 21:10:58'), ('13', 'luoyuan', '123456', '罗远', '2', '2547182011@qq.com', '18201237239', '5301456', '测试', '1023', '1', '1', '2018-07-05 09:33:23', '2018-07-05 09:32:35', '2018-07-05 09:33:31');
COMMIT;

-- ----------------------------
--  Table structure for `userpermission`
-- ----------------------------
DROP TABLE IF EXISTS `userpermission`;
CREATE TABLE `userpermission` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户主键',
  `permissionid` varchar(32) DEFAULT NULL COMMENT '权限主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关联权限表';

-- ----------------------------
--  Table structure for `userunionrole`
-- ----------------------------
DROP TABLE IF EXISTS `userunionrole`;
CREATE TABLE `userunionrole` (
  `id` varchar(32) NOT NULL DEFAULT '' COMMENT '主键',
  `userid` varchar(32) DEFAULT NULL COMMENT '用户主键',
  `roleid` varchar(32) DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户关联角色表';

-- ----------------------------
--  Records of `userunionrole`
-- ----------------------------
BEGIN;
INSERT INTO `userunionrole` VALUES ('1', '12', '123');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
