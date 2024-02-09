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

 Date: 08/02/2024 17:03:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '自增ID',
  `employee_id` varchar(9) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `employee_nickname` varchar(32) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户昵称',
  `employee_head` varchar(16) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `employee_password` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户密码',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `dept_id` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '10000' COMMENT '部门ID',
  `level` varchar(10) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT 'T-1' COMMENT '职级',
  `title` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT '初级工程师' COMMENT '头衔',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uq_uid`(`employee_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES (1, '184172133', '小傅哥', '01_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10000', 'T-1', '初级工程师');
INSERT INTO `employee` VALUES (2, '980765512', '铁锤', '02_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10086', 'T-2', '初级工程师');
INSERT INTO `employee` VALUES (3, '796542178', '团团', '03_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10086', 'T-1', '初级工程师');
INSERT INTO `employee` VALUES (4, '523088136', '哈尼克兔', '04_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10000', 'T-4', '中级工程师');
INSERT INTO `employee` VALUES (5, '123456001', '比丘卡', '05_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10010', 'T-1', '初级工程师');
INSERT INTO `employee` VALUES (6, '123456002', '兰兰', '06_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10010', 'T-3', '中级工程师');
INSERT INTO `employee` VALUES (7, '123456003', 'Alexa', '07_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10086', 'T-1', '初级工程师');
INSERT INTO `employee` VALUES (8, '123456004', '小白', '08_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10086', 'T-5', '高级工程师');
INSERT INTO `employee` VALUES (9, '123456005', '铃铛', '09_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10000', 'T-6', '高级工程师');
INSERT INTO `employee` VALUES (10, '123456006', '马小帅', '10_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10010', 'T-7', '架构师');
INSERT INTO `employee` VALUES (11, '123456007', 'S.A.K', '11_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10010', 'T-1', '初级工程师');
INSERT INTO `employee` VALUES (12, '123456008', '池鱼有点贤', '12_50', '123456', '2023-06-23 00:00:00', '2023-06-23 00:00:00', '10000', 'T-2', '初级工程师');
INSERT INTO `employee` VALUES (29, '999999999', 'djq', '01_01', '666666', '2024-02-07 13:48:34', '2024-02-07 13:48:34', '10086', 'T-1', '初级工程师');

SET FOREIGN_KEY_CHECKS = 1;
