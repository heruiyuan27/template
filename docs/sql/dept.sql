/*
 Navicat Premium Data Transfer

 Source Server         : local host 3306
 Source Server Type    : MySQL
 Source Server Version : 80030
 Source Host           : localhost:3306
 Source Schema         : java

 Target Server Type    : MySQL
 Target Server Version : 80030
 File Encoding         : 65001

 Date: 08/02/2024 17:03:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `dept_id` varchar(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门ID',
  `dept_name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '部门名称',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT NULL COMMENT '是否逻辑删除',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_uid`(`dept_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, '10086', '移动部', '2023-11-19 10:58:14', '2023-11-19 10:58:14', 0);
INSERT INTO `dept` VALUES (4, '10000', '电信部', '2023-11-19 11:01:12', '2023-11-19 11:01:12', 0);
INSERT INTO `dept` VALUES (7, '10010', '联通部', '2023-12-03 11:44:04', '2023-12-03 11:44:04', 0);
INSERT INTO `dept` VALUES (12, '12345', '市民热线', '2023-12-31 07:56:39', '2023-12-31 07:56:39', 1);

SET FOREIGN_KEY_CHECKS = 1;
